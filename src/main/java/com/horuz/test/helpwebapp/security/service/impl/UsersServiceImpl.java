package com.horuz.test.helpwebapp.security.service.impl;

import com.horuz.test.helpwebapp.security.model.Users;
import com.horuz.test.helpwebapp.security.repository.UsersRepository;
import com.horuz.test.helpwebapp.security.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService, UserDetailsService {
    private final UsersRepository usersRepository;

    private static final String USER_NOT_FOUND = "User %s not found";
    private static final String USER_ACCOUNT_ALREADY_EXIST = "This username: %s already exist.";
    @Override
    public void createUser(Users users) {
        if(usersRepository.existsByUsername(users.getUsername())){
            throw new RuntimeException(
                    String.format(USER_ACCOUNT_ALREADY_EXIST, users.getUsername())
            );
        }
        usersRepository.save(users);
    }

    public Optional<Users> findByUsername(String username){
        return usersRepository.findByUsername(username);
    }
    public Optional<Users> findById(Long id){
        return usersRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND, username)
                ));
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList()
        );
    }
}
