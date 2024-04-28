package com.horuz.test.helpwebapp.post.mapper.impl;

import com.horuz.test.helpwebapp.post.mapper.FindRequestToListSelectMapper;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.Select;
import com.horuz.test.helpwebapp.post.repository.PostRepository;
import com.horuz.test.helpwebapp.post.utils.MessageUtil;
import com.horuz.test.helpwebapp.security.api.model.CurrUser;
import com.horuz.test.helpwebapp.security.api.service.IdentityApiService;
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
    @Override
    public List<Select> map(List<Integer> source) {
        CurrUser currUser = identityApiService.currentUserAccount()
                .orElseThrow(() -> new RuntimeException(MessageUtil.USER_NOT_FOUND));

        List<Select> selects = new ArrayList<>();

        for(int i = 0; i < source.size(); i++){
            Select select = new Select();
            select.setUserId(currUser.id());
            Integer idPost = source.get(i);
            Post post = postRepository.findById(source.get(i)).orElseThrow(
                    () -> new RuntimeException(
                            String.format(MessageUtil.POST_NOT_FOUND, idPost)
                    )
            );
            select.setPost(post);
            selects.add(select);
        }
        return selects;
    }
}
