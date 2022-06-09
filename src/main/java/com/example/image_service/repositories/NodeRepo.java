package com.example.image_service.repositories;

import com.example.image_service.entities.ImageNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NodeRepo extends JpaRepository<ImageNode, Long> {
    Optional<ImageNode> findByTypeAndEntId(String type, Long id);
}
