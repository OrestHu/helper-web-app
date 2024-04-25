package com.horuz.test.helpwebapp.security.api.service.impl;

import com.horuz.test.helpwebapp.security.api.model.CurrUser;
import com.horuz.test.helpwebapp.security.api.service.IdentityApiService;
import com.horuz.test.helpwebapp.security.exception.UserNotFoundException;
import com.horuz.test.helpwebapp.security.model.Users;
import com.horuz.test.helpwebapp.security.service.impl.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {
    private final UsersServiceImpl usersService;

    private static final String USER_NOT_FOUND = "User not found by id %s";
    @Override
    public Optional<CurrUser> currentUserAccount() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if(authentication == null){
            return Optional.empty();
        }

        String username = authentication.getName();
        return usersService
                .findByUsername(username)
                .map(userAccount -> new CurrUser(userAccount.getId()));
    }

    @Override
    public Optional<Users> currentUserAccountUsername(Long id) {
        Users userAccount = usersService.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(String.format(USER_NOT_FOUND, id), HttpStatus.NOT_FOUND)
                );
        return Optional.of(userAccount);
    }
}
