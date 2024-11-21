package com.intern.bookreview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticatedUserData {
    private Long id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
}
