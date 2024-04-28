package com.horuz.test.helpwebapp.security.mapper.impl;

import com.horuz.test.helpwebapp.post.utils.MessageUtil;
import com.horuz.test.helpwebapp.security.mapper.RegisterRequestToUserMapper;
import com.horuz.test.helpwebapp.security.model.Role;
import com.horuz.test.helpwebapp.security.model.Users;
import com.horuz.test.helpwebapp.security.model.req.RegisterRequest;
import com.horuz.test.helpwebapp.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class RegisterRequestToUserMapperImpl implements RegisterRequestToUserMapper {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Users map(RegisterRequest source) {
        Users userAccount = new Users();
        userAccount.setUsername(source.email().toLowerCase(Locale.ROOT));
        userAccount.setPassword(passwordEncoder.encode(source.password()));
        userAccount.setFullName(source.fullName());
        Role role = roleRepository.findByName(source.role())
                .orElseThrow(() -> new RuntimeException(
                        String.format(MessageUtil.ROLE_NOT_FOUND_ERROR)
                ));
        userAccount.setRoles(List.of(role));
        return userAccount;
    }
}
