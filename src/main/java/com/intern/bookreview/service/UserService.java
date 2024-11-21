package com.intern.bookreview.service;

import com.intern.bookreview.dto.AuthRequestDTO;
import com.intern.bookreview.dto.AuthResponseDTO;
import com.intern.bookreview.dto.UsersDTO;

public interface UserService {
    AuthResponseDTO verify(AuthRequestDTO authRequestDTO);
    UsersDTO signup(UsersDTO usersDTO);
}
