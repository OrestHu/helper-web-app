package com.horuz.test.helpwebapp.post.usecase.impl;

import com.horuz.test.helpwebapp.post.mapper.PostToPostResponseMapper;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.Select;
import com.horuz.test.helpwebapp.post.model.req.FindRequest;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import com.horuz.test.helpwebapp.post.model.resp.SelectedResponse;
import com.horuz.test.helpwebapp.post.repository.PostRepository;
import com.horuz.test.helpwebapp.post.repository.SelectRepository;
import com.horuz.test.helpwebapp.post.service.SelectService;
import com.horuz.test.helpwebapp.post.usecase.SelectUseCase;
import com.horuz.test.helpwebapp.post.utils.MessageUtil;
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
public class SelectUseCaseImpl implements SelectUseCase {
    private final PostToPostResponseMapper postToPostResponseMapper;
    private final PostRepository postRepository;
    private final SelectRepository selectRepository;
    private final SelectService selectService;
    private final IdentityApiService identityApiService;
    @Override
    public void makeSelect(FindRequest request) {
        CurrUser currUser = identityApiService.currentUserAccount()
                .orElseThrow(
                        () -> new UserNotFoundException(
                                MessageUtil.USER_NOT_FOUND_NOT_NAME, HttpStatus.BAD_REQUEST
                        )
                );

        List<Select> input = selectService.findSelectByUser(currUser.id());
        List<Integer> output = request.output();
        List<Integer> inputInt = new ArrayList<>();

        for(int i = 0; i < input.size(); i++){
            inputInt.add(input.get(i).getPost().getId());
        }

        for(int i = 0; i < output.size(); i++){
            if(!inputInt.contains(output.get(i))){
                Select select = new Select();
                select.setUserId(currUser.id());
                Post post = postRepository.findById(output.get(i)).orElseThrow();
                select.setPost(post);
                selectRepository.save(select);
            }else{
                selectService.deleteSelects(output.get(i));
            }
        }
    }


    @Override
    public List<PostResponse> findPostsBySelects() {
        CurrUser currUser = identityApiService.currentUserAccount()
                .orElseThrow(
                        () -> new UserNotFoundException(
                                MessageUtil.USER_NOT_FOUND_NOT_NAME, HttpStatus.BAD_REQUEST
                        )
                );
        List<Post> posts = selectService.findPostsBySelects(currUser.id());
        return posts
                .stream()
                .map(postToPostResponseMapper::map)
                .toList();
    }

    @Override
    public SelectedResponse listSelected() {
        CurrUser currUser = identityApiService.currentUserAccount()
                .orElseThrow(
                        () -> new UserNotFoundException(
                                MessageUtil.USER_NOT_FOUND_NOT_NAME, HttpStatus.BAD_REQUEST
                        )
                );
        List<Select> selects = selectService.listSelected(currUser.id());
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < selects.size(); i++){
            list.add(selects.get(i).getPost().getId());
        }
        return new SelectedResponse(list);
    }
}
