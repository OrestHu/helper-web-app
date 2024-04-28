package com.horuz.test.helpwebapp.post.repository;

import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    boolean existsByName(String name);
    boolean existsById(Integer id);
    List<Post> findByNameContainingIgnoreCase(String text);
    List<Post> findAllByUser(Users users);
}
