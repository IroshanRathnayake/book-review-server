package com.intern.bookreview.controller;

import com.intern.bookreview.dto.AuthRequestDTO;
import com.intern.bookreview.dto.AuthResponseDTO;
import com.intern.bookreview.dto.UsersDTO;
import com.intern.bookreview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authRequestDTO) {
        return new ResponseEntity<>(userService.verify(authRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<UsersDTO> signup(@RequestBody UsersDTO usersDTO) {
        return new ResponseEntity<>(userService.signup(usersDTO), HttpStatus.OK);
    }
}
