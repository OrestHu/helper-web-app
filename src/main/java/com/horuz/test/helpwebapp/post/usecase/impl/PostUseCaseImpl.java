package com.horuz.test.helpwebapp.post.usecase.impl;

import com.horuz.test.helpwebapp.post.mapper.FindRequestToListSelectMapper;
import com.horuz.test.helpwebapp.post.mapper.PostRequestToPostMapper;
import com.horuz.test.helpwebapp.post.mapper.PostToPostResponseMapper;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.Select;
import com.horuz.test.helpwebapp.post.model.req.FindRequest;
import com.horuz.test.helpwebapp.post.model.req.PostRequest;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import com.horuz.test.helpwebapp.post.service.PostService;
import com.horuz.test.helpwebapp.post.usecase.PostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PostUseCaseImpl implements PostUseCase {
    private final PostService postService;
    private final PostRequestToPostMapper postRequestToPostMapper;
    private final PostToPostResponseMapper postToPostResponseMapper;
    @Override
    public void createPost(PostRequest request) {
        Post post = postRequestToPostMapper.map(request);
        postService.createPost(post);
    }
    @Override
    public List<PostResponse> findAll() {
        List<Post> all = postService.findAll();
        return all
                .stream()
                .map(postToPostResponseMapper::map)
                .toList();
    }

}
