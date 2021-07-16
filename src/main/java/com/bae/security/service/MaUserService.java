package com.bae.security.service;

import com.bae.entity.user.MaUser;
import com.bae.security.request.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * date 2021-03-24 15:02
 *
 * @author Phạm Ngọc Thắng
 */


public interface MaUserService extends UserDetailsService {
    UserDetails loadUserByUsername(String username);

    UserDetails loadUserById(Long id);

    UserDetails createAccount(RegisterRequest request);

    void checkUserInMaUser(MaUser maUser);
}
