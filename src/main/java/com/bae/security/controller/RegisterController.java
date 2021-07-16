package com.bae.security.controller;

import com.bae.response.common.NewDataResponse;
import com.bae.security.request.RegisterRequest;
import com.bae.security.service.MaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/test")
public class RegisterController {

    @Autowired
    private MaUserService maUserService;

    @PostMapping("/createAccount")
    public ResponseEntity createAccount(@RequestBody RegisterRequest request ) {
        UserDetails response =  maUserService.createAccount(request);
        return NewDataResponse.setDataCreate(response);
    }
}
