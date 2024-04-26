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
    @Column(name = "user_id")
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;
}
