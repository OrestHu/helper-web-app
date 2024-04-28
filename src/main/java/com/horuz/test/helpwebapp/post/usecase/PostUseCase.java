package com.horuz.test.helpwebapp.post.usecase;

import com.horuz.test.helpwebapp.post.model.req.PostRequest;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface PostUseCase {
    void createPost(@Valid PostRequest request);
    List<PostResponse> findAll();
    List<PostResponse> find(String text);
    List<PostResponse> findByReceiver();
    void deletePost(Integer postId);
    void changePost(Integer postId, PostRequest request);
}
