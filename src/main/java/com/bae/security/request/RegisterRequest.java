package com.bae.security.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotBlank
        private String password;

    @NotBlank
    @Email
    private String email;
}
