package com.intern.bookreview.controller;

import com.intern.bookreview.dto.AuthRequestDTO;
import com.intern.bookreview.dto.AuthResponseDTO;
import com.intern.bookreview.dto.UserDTO;
import com.intern.bookreview.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authRequestDTO) {
        return new ResponseEntity<>(authService.verify(authRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(authService.signup(userDTO), HttpStatus.OK);
    }
}
