package com.intern.bookreview.service.impl;

import com.intern.bookreview.config.SecurityConfig;
import com.intern.bookreview.dto.AuthRequestDTO;
import com.intern.bookreview.dto.AuthResponseDTO;
import com.intern.bookreview.dto.UserDTO;
import com.intern.bookreview.entity.User;
import com.intern.bookreview.exception.CustomException;
import com.intern.bookreview.repository.UserRepository;
import com.intern.bookreview.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public AuthResponseDTO verify(AuthRequestDTO authRequestDTO) {
        if(userRepository.findByEmail(authRequestDTO.getEmail()) != null){
            User user = userRepository.findByEmail(authRequestDTO.getEmail());
            if(SecurityConfig.verifyPassword(authRequestDTO.getPassword(), user.getPassword())){
                return new AuthResponseDTO(
                        user.getId(),
                        user.getUserName(),
                        user.getEmail(),
                        user.getFirstName(),
                        user.getLastName()
                );
            }else{
                throw new CustomException("Incorrect Password", HttpStatus.FORBIDDEN);
            }
        }
        throw new CustomException("User Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public UserDTO signup(UserDTO userDTO) {
        userDTO.setPassword(SecurityConfig.hashPassword(userDTO.getPassword()));
        userDTO.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userDTO.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userDTO.setIsEnabled(true);
        User user = mapper.map(userDTO, User.class);
        return mapper.map(userRepository.save(user), UserDTO.class);
    }
}
