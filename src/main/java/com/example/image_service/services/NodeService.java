package com.example.image_service.services;

import com.example.image_service.DTOs.NodeDTO;

public interface NodeService {
    byte[] getImage(String type, Long entId);

    byte[] getDefault();

    void add(NodeDTO nodeDTO);
}
