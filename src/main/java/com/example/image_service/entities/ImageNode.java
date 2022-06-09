package com.example.image_service.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ImageNode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ent_id")
    private Long entId;
    @Column(name = "type")
    private String type;
    @Column(name = "title")
    private String title;
}
