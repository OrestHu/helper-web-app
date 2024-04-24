package com.horuz.test.helpwebapp.security.usecase;

import com.horuz.test.helpwebapp.security.model.AccessToken;
import com.horuz.test.helpwebapp.security.model.req.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface LoginUseCase {
    AccessToken authAcc(@Valid LoginRequest request);
}
