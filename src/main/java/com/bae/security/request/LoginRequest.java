package com.bae.security.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * date 2021-03-24 16:46
 *
 * @author Phạm Ngọc Thắng
 */

@Data
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

//    @StringInList(values = {AppTypeConstant.SCHOOL, AppTypeConstant.TEACHER, AppTypeConstant.PARENT})
//    private String appType;
}
