package com.horuz.test.helpwebapp.security.api.service.impl;

import com.horuz.test.helpwebapp.post.utils.MessageUtil;
import com.horuz.test.helpwebapp.security.api.model.CurrUser;
import com.horuz.test.helpwebapp.security.api.service.IdentityApiService;
import com.horuz.test.helpwebapp.security.model.Users;
import com.horuz.test.helpwebapp.security.service.impl.UsersServiceImpl;
import com.horuz.test.helpwebapp.security.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {
    private final UsersServiceImpl usersService;
    private final JwtTokenUtils jwtTokenUtils;

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
                        new RuntimeException(String.format(MessageUtil.USER_NOT_FOUND, id))
                );
        return Optional.of(userAccount);
    }

    @Override
    public boolean hasRoleReceiver(String token) {
        List<String> roles = jwtTokenUtils.getRoles(token);

        return roles.stream()
                .anyMatch(role -> role.equals("ROLE_USER_RECEIVER"));
    }

    @Override
    public boolean hasRoleHelper(String token) {
        List<String> roles = jwtTokenUtils.getRoles(token);

        return roles.stream()
                .anyMatch(role -> role.equals("ROLE_USER_HELPER"));
    }
}
