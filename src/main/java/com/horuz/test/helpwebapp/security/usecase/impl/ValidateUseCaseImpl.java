package com.horuz.test.helpwebapp.security.usecase.impl;

import com.horuz.test.helpwebapp.security.api.service.IdentityApiService;
import com.horuz.test.helpwebapp.security.usecase.ValidateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateUseCaseImpl implements ValidateUseCase {
    private final IdentityApiService identityApiService;
    @Override
    public boolean checkReceiver(String jwt) {
        return identityApiService.hasRoleReceiver(jwt);
    }

    @Override
    public boolean checkHelper(String jwt) {
        return identityApiService.hasRoleHelper(jwt);
    }
}
