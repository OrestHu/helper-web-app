package com.horuz.test.helpwebapp.post.model.req;

public record PostRequest(
        String name,
        String description,
        String city,
        String img
) {
}
