package com.horuz.test.helpwebapp.post.usecase;

import com.horuz.test.helpwebapp.post.model.req.FindRequest;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface SelectUseCase {
    void makeSelect(@Valid FindRequest request);
    List<PostResponse> findPostsBySelects();
    void deleteSelects(FindRequest request);
}
