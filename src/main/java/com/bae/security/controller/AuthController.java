package com.bae.security.controller;

import com.bae.common.MessageWebConstant;
import com.bae.entity.user.MaUser;
import com.bae.entity.user.Role;
import com.bae.response.common.NewDataResponse;
import com.bae.security.jwt.JwtTokenProvider;
import com.bae.security.model.UserPrincipal;
import com.bae.security.request.LoginRequest;
import com.bae.security.response.JwtAuthenticationResponse;
import com.bae.repository.UserRepository;
import com.bae.security.service.MaUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

/**
 * date 2021-03-24 16:45
 *
 * @author Phạm Ngọc Thắng
 */

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository maUserRepository;

    @Autowired
    private MaUserService maUserService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/signin")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//        loginRequest = this.getLoginWebRequest(loginRequest);
        logger.info("login information web: {} ", loginRequest);
//        String usernameExtend = ChangeUsernameUtil.changeUsername(loginRequest.getAppType());
//        loginRequest.setUsername(loginRequest.getUsername().concat(usernameExtend));

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // lấy ra id người dùng đang đăng nhập
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Long userId = userPrincipal.getMaUser().getId();
        MaUser maUser = maUserRepository.findById(userId).orElseThrow();
        //kiểm tra tính hợp lệ của tài khoản
        maUserService.checkUserInMaUser(maUser);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);


        // các giá trị trả về khi đăng nhập thành công
//        MaUser maUser = userRepository.findByIdAndDelActiveTrueAndActivatedTrue(userId).orElseThrow(() -> new NotFoundException("Không tìm thấy tài khoản theo id chưa bị xóa và còn kích hoạt"));
//        String appType = maUser.getAppType();

        String currentUser = maUser.getFullName();
        Set<Role> userRole = Set.copyOf(maUser.getRoleList());
        // vài trò của người dùng
        Set<String> roleSet = new HashSet<>();
        // các api đang đăng nhập
        Set<String> apiSet = new HashSet<>();

        userRole.forEach(role -> {
            roleSet.add(role.getRoleName());
            role.getApiList().forEach(api -> {
                apiSet.add(api.getApiUrl());
            });
        });
        response.setAccessToken(jwt);
        response.setCurrentUser(currentUser);
//        response.setAppType(appType);
        response.setRole(roleSet);
        response.setApiSet(apiSet);
//        this.setAvatarUser(maUser, response);
//        this.setInforSchool(maUser, response);
        logger.info("------Login success web------");
        return NewDataResponse.setDataCustom(response, MessageWebConstant.LOGIN_SUCCESS);
    }

    private LoginRequest getLoginWebRequest(LoginRequest request) {
        request.setUsername(request.getUsername().trim());
        request.setPassword(request.getPassword().trim());
        return request;
    }
}
