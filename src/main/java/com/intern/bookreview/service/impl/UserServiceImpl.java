package com.intern.bookreview.service.impl;

import com.intern.bookreview.dto.AuthRequestDTO;
import com.intern.bookreview.dto.AuthResponseDTO;
import com.intern.bookreview.dto.AuthenticatedUserData;
import com.intern.bookreview.dto.UsersDTO;
import com.intern.bookreview.entity.Users;
import com.intern.bookreview.exception.CustomException;
import com.intern.bookreview.repository.UserRepository;
import com.intern.bookreview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AuthenticationManager authManager;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public AuthResponseDTO verify(AuthRequestDTO authRequest) {
        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authRequest.getEmail(),
                                authRequest.getPassword()
                        )
                );

        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(authRequest.getEmail());
            UsersDTO user = mapper.map(userRepository.findByEmail(authRequest.getEmail()), UsersDTO.class);
            System.out.println(user);
            return new AuthResponseDTO(token,
                   new AuthenticatedUserData(
                           user.getId(),
                           user.getUserName(),
                           user.getEmail(),
                           user.getFirstName(),
                           user.getLastName(),
                           user.getRole()
                   )
            );
        }
        throw new CustomException("Access Denied", HttpStatus.FORBIDDEN);
    }

    @Override
    public UsersDTO signup(UsersDTO usersDTO) {
        usersDTO.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
        usersDTO.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        usersDTO.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        usersDTO.setIsEnabled(true);
        usersDTO.setRole("user");
        Users users = mapper.map(usersDTO, Users.class);
        return mapper.map(userRepository.save(users), UsersDTO.class);
    }
}
