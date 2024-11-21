package com.intern.bookreview.service.impl;

import com.intern.bookreview.dto.UserPrinciple;
import com.intern.bookreview.entity.Users;
import com.intern.bookreview.repository.UserRepository;
import com.intern.bookreview.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users authUsers = userRepository.findByEmail(username);

        if(authUsers == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrinciple(authUsers);
    }

}
