package com.horuz.test.helpwebapp.post.mapper.impl;

import com.horuz.test.helpwebapp.post.exception.PostNotFoundException;
import com.horuz.test.helpwebapp.post.mapper.FindRequestToListSelectMapper;
import com.horuz.test.helpwebapp.post.model.Select;
import com.horuz.test.helpwebapp.post.model.req.FindRequest;
import com.horuz.test.helpwebapp.post.repository.PostRepository;
import com.horuz.test.helpwebapp.post.service.PostService;
import com.horuz.test.helpwebapp.security.api.model.CurrUser;
import com.horuz.test.helpwebapp.security.api.service.IdentityApiService;
import com.horuz.test.helpwebapp.security.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FindRequestToListSelectMapperImpl implements FindRequestToListSelectMapper {
    private final IdentityApiService identityApiService;
    private final PostRepository postRepository;
    private static final String USER_NOT_FOUND = "User not found by this id %s";
    private static final String POST_NOT_FOUND = "Post not found by this id %s";
    @Override
    public List<Select> map(FindRequest source) {
        CurrUser currUser = identityApiService.currentUserAccount()
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND, HttpStatus.BAD_REQUEST));
        List<Integer> postListId = source.list();
        List<Select> selects = new ArrayList<>();

        for(int i = 0; i < postListId.size(); i++){
            Select select = new Select();
            select.setUserId(currUser.id());
            Integer idPost = postListId.get(i);
            postRepository.findById(postListId.get(i)).orElseThrow(
                    () -> new PostNotFoundException(
                            String.format(POST_NOT_FOUND, idPost), HttpStatus.BAD_REQUEST
                    )
            );
            select.setPostId(postListId.get(i));
            selects.add(select);
            System.out.println(select);
        }
        return selects;
    }
}
