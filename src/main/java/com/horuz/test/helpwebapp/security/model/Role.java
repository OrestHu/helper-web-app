package com.horuz.test.helpwebapp.security.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "identity_help", name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
}
