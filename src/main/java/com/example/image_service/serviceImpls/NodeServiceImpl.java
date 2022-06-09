package com.example.image_service.serviceImpls;

import com.example.image_service.DTOs.NodeDTO;
import com.example.image_service.entities.ImageNode;
import com.example.image_service.repositories.NodeRepo;
import com.example.image_service.services.NodeService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NodeServiceImpl implements NodeService {
    private static String dir="/imgs";
    private final NodeRepo nodeRepo;
    @Override
    @SneakyThrows
    public byte[] getImage(String type, Long entId) {
        ImageNode node=nodeRepo.findByTypeAndEntId(type, entId).orElse(null);
        if (node==null) return null;
        InputStream in=getClass().getResourceAsStream("/imgs/"+type+"/"+node.getTitle());//(dir+"/"+type+"/"+node.getTitle());
        if(in == null) return getDefault();
        byte[] b=IOUtils.toByteArray(in);
        in.close();
        return b;
    }

    @Override
    @SneakyThrows
    public byte[] getDefault() {
        InputStream in=getClass().getResourceAsStream("/imgs/test.png");
        return IOUtils.toByteArray(in);
    }

    @Override
    public void add(NodeDTO nodeDTO) {
        ImageNode node=ImageNode.builder()
                .entId(nodeDTO.getEntId())
                .title(nodeDTO.getTitle())
                .type(nodeDTO.getType())
                .build();
        nodeRepo.save(node);
    }
}
