package com.horuz.test.helpwebapp.security.usecase.impl;

import com.horuz.test.helpwebapp.security.api.service.IdentityApiService;
import com.horuz.test.helpwebapp.security.usecase.ValidateUseCase;
import com.horuz.test.helpwebapp.security.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateUseCaseImpl implements ValidateUseCase {
    private final IdentityApiService identityApiService;
    private final JwtTokenUtils jwtTokenUtils;

    @Override
    public boolean checkValidToken(String jwt) {
        return jwtTokenUtils.checkValidToken(jwt);
    }

    @Override
    public boolean checkReceiver(String jwt) {
        return identityApiService.hasRoleReceiver(jwt);
    }

    @Override
    public boolean checkHelper(String jwt) {
        return identityApiService.hasRoleHelper(jwt);
    }
}
