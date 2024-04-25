package com.horuz.test.helpwebapp.post.model.resp;

import java.time.Instant;

public record PostResponse(
        int id,
        String name,
        String description,
        String city,
        String img,
        Instant createdTimeStamp
) {
}
