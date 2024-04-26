package com.horuz.test.helpwebapp.post.service;

import com.horuz.test.helpwebapp.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void createPost(Post post);
    List<Post> findAll();
    Optional<Post> findById(Integer id);
    void deletePost(Integer postId);
    void changePost(Post post);
}
