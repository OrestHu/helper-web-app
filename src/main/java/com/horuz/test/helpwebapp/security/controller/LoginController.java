package com.horuz.test.helpwebapp.security.controller;

import com.horuz.test.helpwebapp.security.model.AccessToken;
import com.horuz.test.helpwebapp.security.model.req.LoginRequest;
import com.horuz.test.helpwebapp.security.usecase.LoginUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authentication")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccessToken authAccount(@Valid @RequestBody LoginRequest request){
        return loginUseCase.authAcc(request);
    }
}
