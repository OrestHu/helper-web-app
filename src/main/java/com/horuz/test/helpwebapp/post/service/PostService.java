package com.horuz.test.helpwebapp.post.service;

import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.Select;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void createPost(Post post);
    List<Post> findAll();
    Post findById(Integer id);
}
