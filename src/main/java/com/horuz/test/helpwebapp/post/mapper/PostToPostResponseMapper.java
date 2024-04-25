package com.horuz.test.helpwebapp.post.mapper;

import com.horuz.test.helpwebapp.post.model.Post;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import com.horuz.test.helpwebapp.security.mapper.Mapper;

import java.util.Map;

public interface PostToPostResponseMapper extends Mapper<PostResponse, Post> {
}
