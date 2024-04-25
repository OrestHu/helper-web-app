package com.horuz.test.helpwebapp.post.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "help", name = "selects")
public class Select {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long userId;
    private Integer postId;
}
