package com.horuz.test.helpwebapp.post.service.impl;

import com.horuz.test.helpwebapp.post.exception.PostExistException;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.repository.PostRepository;
import com.horuz.test.helpwebapp.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    private static final String POST_ALREADY_EXIST = "Post %s already exist";
    @Override
    public void createPost(Post post) {
        if(postRepository.existsByName(post.getName())){
            throw new PostExistException(
                    String.format(POST_ALREADY_EXIST, post.getName()), HttpStatus.CONFLICT
            );
        }
        postRepository.save(post);
    }
    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
