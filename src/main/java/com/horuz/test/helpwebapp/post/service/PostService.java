package com.horuz.test.helpwebapp.post.service;

import com.horuz.test.helpwebapp.post.model.Post;

import java.util.List;

public interface PostService {
    void createPost(Post post);
    List<Post> findAll();
}
