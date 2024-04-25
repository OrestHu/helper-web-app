package com.horuz.test.helpwebapp.post.usecase.impl;

import com.horuz.test.helpwebapp.post.mapper.FindRequestToListSelectMapper;
import com.horuz.test.helpwebapp.post.mapper.PostToPostResponseMapper;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.Select;
import com.horuz.test.helpwebapp.post.model.req.FindRequest;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import com.horuz.test.helpwebapp.post.service.SelectService;
import com.horuz.test.helpwebapp.post.usecase.SelectUseCase;
import com.horuz.test.helpwebapp.security.api.model.CurrUser;
import com.horuz.test.helpwebapp.security.api.service.IdentityApiService;
import com.horuz.test.helpwebapp.security.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SelectUseCaseImpl implements SelectUseCase {
    private final FindRequestToListSelectMapper findRequestToListSelectMapper;
    private final PostToPostResponseMapper postToPostResponseMapper;
    private final SelectService selectService;
    private final IdentityApiService identityApiService;

    private static final String USER_NOT_FOUND = "User not found";
    @Override
    public void makeSelect(FindRequest request) {
        List<Select> map = findRequestToListSelectMapper.map(request);
        map
                .stream()
                .forEach(selectService::makeSelect);

    }

    @Override
    public List<PostResponse> findPostsBySelects() {
        CurrUser currUser = identityApiService.currentUserAccount()
                .orElseThrow(
                        () -> new UserNotFoundException(
                                USER_NOT_FOUND, HttpStatus.BAD_REQUEST
                        )
                );
        List<Post> posts = selectService.findPostsBySelects(currUser.id());
        return posts
                .stream()
                .map(postToPostResponseMapper::map)
                .toList();
    }

    @Override
    public void deleteSelects(FindRequest request) {
        request.list()
                .stream()
                .forEach(selectService::deleteSelects);
    }
}
