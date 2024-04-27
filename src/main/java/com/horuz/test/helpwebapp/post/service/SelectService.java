package com.horuz.test.helpwebapp.post.service;

import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.Select;

import java.util.List;

public interface SelectService {
    void makeSelect(Select select);
    List<Post> findPostsBySelects(Long user_id);
    List<Select> findSelectByUser(Long user_id);
    List<Select> listSelected(Long id);
    boolean selected(Integer postId);
    void deleteSelects(Integer integer);
}
