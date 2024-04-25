package com.horuz.test.helpwebapp.post.service;

import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.Select;

import java.util.List;

public interface SelectService {
    void makeSelect(Select select);
    List<Post> findPostsBySelects(Long user_id);
    void deleteSelects(Integer select);
}
