package com.horuz.test.helpwebapp.security.repository;

import com.horuz.test.helpwebapp.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
