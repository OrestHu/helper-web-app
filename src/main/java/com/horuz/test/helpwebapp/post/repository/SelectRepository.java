package com.horuz.test.helpwebapp.post.repository;

import com.horuz.test.helpwebapp.post.model.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectRepository extends JpaRepository<Select, Integer> {
    List<Select> findByUserId(Long userId);
}