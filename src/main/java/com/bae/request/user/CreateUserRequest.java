package com.bae.request.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateUserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
