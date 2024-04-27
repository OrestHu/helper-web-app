package com.horuz.test.helpwebapp.post.controller;

import com.horuz.test.helpwebapp.post.model.req.FindRequest;
import com.horuz.test.helpwebapp.post.model.resp.PostResponse;
import com.horuz.test.helpwebapp.post.model.resp.SelectedResponse;
import com.horuz.test.helpwebapp.post.usecase.SelectUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/select")
@RequiredArgsConstructor
public class SelectController {
    private final SelectUseCase selectUseCase;
    @PostMapping("/makeSelect")
    @ResponseStatus(HttpStatus.CREATED)
    public void makeSelect(@Valid @RequestBody FindRequest request){
        selectUseCase.makeSelect(request);
    }
    @GetMapping("/findSelects")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PostResponse> findPostsBySelects(){
        return selectUseCase.findPostsBySelects();
    }
    @GetMapping("/listSelected")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SelectedResponse listSelected(){
        return selectUseCase.listSelected();
    }
}
