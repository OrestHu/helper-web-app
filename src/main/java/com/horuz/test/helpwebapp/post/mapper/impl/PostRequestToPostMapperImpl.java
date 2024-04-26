package com.horuz.test.helpwebapp.post.mapper.impl;

import com.horuz.test.helpwebapp.post.mapper.PostRequestToPostMapper;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.req.PostRequest;
import com.horuz.test.helpwebapp.security.api.model.CurrUser;
import com.horuz.test.helpwebapp.security.api.service.IdentityApiService;
import com.horuz.test.helpwebapp.security.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class PostRequestToPostMapperImpl implements PostRequestToPostMapper {
    private final IdentityApiService identityApiService;
    @Override
    public Post map(PostRequest source) {
        CurrUser currUser = identityApiService.currentUserAccount().orElseThrow();
        Users users = identityApiService.currentUserAccountUsername(currUser.id()).orElseThrow();

        Post post = new Post();
        post.setName(source.name());
        post.setDescription(source.description());
        post.setCity(source.city());
        post.setPhone(source.phone());
        post.setImg(source.img());
        post.setCreatedTimeStamp(Instant.now());
        post.setUser(users);
        return post;
    }
}
