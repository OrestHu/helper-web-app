package com.horuz.test.helpwebapp.post.repository;

import com.horuz.test.helpwebapp.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    boolean existsByName(String name);
    boolean existsById(Integer id);
}
