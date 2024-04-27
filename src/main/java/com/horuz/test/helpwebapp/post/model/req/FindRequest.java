package com.horuz.test.helpwebapp.post.model.req;

import java.util.List;

public record FindRequest(
        List<Integer> output
) {
}
