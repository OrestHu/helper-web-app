package com.horuz.test.helpwebapp.post.service.impl;

import com.horuz.test.helpwebapp.post.exception.PostExistException;
import com.horuz.test.helpwebapp.post.exception.PostNotFoundException;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.repository.PostRepository;
import com.horuz.test.helpwebapp.post.service.PostService;
import com.horuz.test.helpwebapp.post.utils.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public void createPost(Post post) {
        if(postRepository.existsByName(post.getName())){
            throw new PostExistException(
                    String.format(MessageUtil.POST_ALREADY_EXIST, post.getName()), HttpStatus.CONFLICT
            );
        }
        postRepository.save(post);
    }
    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> find(String text) {
        return postRepository.findByDescriptionContaining(text);
    }

    @Override
    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public void deletePost(Integer postId) {
        if(!postRepository.existsById(postId)){
            throw new PostNotFoundException(
                    String.format(MessageUtil.POST_NOT_FOUND, postId), HttpStatus.BAD_REQUEST
            );
        }
        postRepository.deleteById(postId);
    }

    @Override
    public void changePost(Post post) {
        postRepository.save(post);
    }

}
