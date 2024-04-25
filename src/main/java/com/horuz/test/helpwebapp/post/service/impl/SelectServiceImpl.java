package com.horuz.test.helpwebapp.post.service.impl;

import com.horuz.test.helpwebapp.post.exception.PostNotFoundException;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.Select;
import com.horuz.test.helpwebapp.post.repository.SelectRepository;
import com.horuz.test.helpwebapp.post.service.PostService;
import com.horuz.test.helpwebapp.post.service.SelectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SelectServiceImpl implements SelectService {
    private final SelectRepository selectRepository;
    private final PostService postService;

    private static final String POST_NOT_FOUND = "Post %d not found";
    @Override
    public void makeSelect(Select select) {
        selectRepository.save(select);
    }

    @Override
    public List<Post> findPostsBySelects(Long user_id) {
        List<Select> byUserId = selectRepository.findByUserId(user_id);

        return byUserId.stream()
                .map(select -> postService.findById(select.getPostId()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSelects(Integer select) {
        Select byPostId = selectRepository
                .findByPostId(select)
                .orElseThrow(() -> new PostNotFoundException(
                        String.format(POST_NOT_FOUND, select), HttpStatus.BAD_REQUEST
                ));
        selectRepository.delete(byPostId);
    }
}
