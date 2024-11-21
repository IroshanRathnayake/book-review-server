package com.intern.bookreview.service;

import com.intern.bookreview.dto.AuthRequestDTO;
import com.intern.bookreview.dto.AuthResponseDTO;
import com.intern.bookreview.dto.UserDTO;

public interface AuthService {
    AuthResponseDTO verify(AuthRequestDTO authRequestDTO);
    UserDTO signup(UserDTO userDTO);
}
