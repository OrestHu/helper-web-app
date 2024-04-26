package com.horuz.test.helpwebapp.post.model;

import com.horuz.test.helpwebapp.security.model.Users;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(schema = "help", name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "phone")
    private String phone;
    @Column(name = "img")
    private String img;
    private Instant createdTimeStamp;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;
}
