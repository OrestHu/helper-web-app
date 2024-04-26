package com.horuz.test.helpwebapp.post.controller;

import com.horuz.test.helpwebapp.post.model.req.PostRequest;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import com.horuz.test.helpwebapp.post.usecase.PostUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostUseCase postUseCase;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@Valid @RequestBody PostRequest request){
        postUseCase.createPost(request);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PostResponse> findAll(){
        return postUseCase.findAll();
    }

    @DeleteMapping("/deletePost/{post_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("post_id") Integer postId){
        postUseCase.deletePost(postId);
    }

    @PatchMapping("/changePost/{post_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void changePost(@PathVariable("post_id") Integer postId, @Valid @RequestBody PostRequest request){
        postUseCase.changePost(postId, request);
    }
}
