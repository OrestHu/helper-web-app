package com.horuz.test.helpwebapp.security.controller;

import com.horuz.test.helpwebapp.security.model.req.RegisterRequest;
import com.horuz.test.helpwebapp.security.usecase.RegisterUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterUseCase registerUseCase;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest request){
        registerUseCase.createUser(request);
    }
}
