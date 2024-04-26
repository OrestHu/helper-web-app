package com.horuz.test.helpwebapp.post.usecase.impl;

import com.horuz.test.helpwebapp.post.exception.PostNotFoundException;
import com.horuz.test.helpwebapp.post.mapper.PostRequestToPostMapper;
import com.horuz.test.helpwebapp.post.mapper.PostToPostResponseMapper;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.req.PostRequest;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import com.horuz.test.helpwebapp.post.service.PostService;
import com.horuz.test.helpwebapp.post.usecase.PostUseCase;
import com.horuz.test.helpwebapp.post.utils.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @Override
    public List<PostResponse> find(String text) {
        List<Post> posts = postService.find(text);
        return posts
                .stream()
                .map(postToPostResponseMapper::map)
                .toList();
    }

    @Override
    public void deletePost(Integer postId) {
        postService.deletePost(postId);
    }

    @Override
    public void changePost(Integer postId, PostRequest request) {
        Post post = postService.findById(postId).orElseThrow(
                () -> new PostNotFoundException(
                        String.format(MessageUtil.POST_NOT_FOUND, postId), HttpStatus.BAD_REQUEST
                )
        );

        post.setName(request.name());
        post.setDescription(request.description());
        post.setCity(request.city());
        post.setPhone(request.phone());
        post.setImg(request.img());

        postService.changePost(post);
    }
}
