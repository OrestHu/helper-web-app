package com.horuz.test.helpwebapp.security.usecase;

import com.horuz.test.helpwebapp.security.model.req.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
@Validated
public interface RegisterUseCase {
    void createUser(@Valid RegisterRequest request);
}
