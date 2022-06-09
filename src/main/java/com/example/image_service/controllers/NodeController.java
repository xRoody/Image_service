package com.example.image_service.controllers;

import com.example.image_service.DTOs.NodeDTO;
import com.example.image_service.services.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class NodeController {
    private final NodeService nodeService;

    @GetMapping(value = "/{type}/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("type") String type, @PathVariable("id") Long entId){
        byte[] rez=nodeService.getImage(type, entId);
        if(rez==null) return ResponseEntity.ok(nodeService.getDefault());
        return ResponseEntity.ok().header(HttpHeaders.CACHE_CONTROL,"no-cache", "no-store","must-revalidate").body(rez);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> createNode(@RequestBody NodeDTO nodeDTO){
        nodeService.add(nodeDTO);
        return ResponseEntity.created(URI.create("/")).build();
    }
}
