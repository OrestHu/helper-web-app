package com.horuz.test.helpwebapp.security.usecase.impl;

import com.horuz.test.helpwebapp.security.mapper.RegisterRequestToUserMapper;
import com.horuz.test.helpwebapp.security.model.Users;
import com.horuz.test.helpwebapp.security.model.req.RegisterRequest;
import com.horuz.test.helpwebapp.security.service.UsersService;
import com.horuz.test.helpwebapp.security.usecase.RegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUseCaseImpl implements RegisterUseCase {
    private final UsersService usersService;
    private final RegisterRequestToUserMapper registerRequestToUserMapper;
    @Override
    public void createUser(RegisterRequest request) {
        Users user = registerRequestToUserMapper.map(request);
        usersService.createUser(user);
    }
}
