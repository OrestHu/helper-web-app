package com.horuz.test.helpwebapp.post.service;

import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.security.model.Users;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void createPost(Post post);
    List<Post> findAll();
    List<Post> find(String text);
    List<Post> findByReceiver(Users users);
    Optional<Post> findById(Integer id);
    void deletePost(Integer postId);
    void changePost(Post post);
}
