package com.horuz.test.helpwebapp.post.mapper.impl;

import com.horuz.test.helpwebapp.post.mapper.PostToPostResponseMapper;
import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import com.horuz.test.helpwebapp.post.service.SelectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostToPostResponseMapperImpl implements PostToPostResponseMapper {
    private final SelectService selectService;
    @Override
    public PostResponse map(Post source) {

        return new PostResponse(
                source.getId(),
                source.getName(),
                source.getDescription(),
                source.getCity(),
                source.getPhone(),
                source.getImg(),
                source.getCreatedTimeStamp(),
                selectService.selected(source.getId())
        );
    }
}
