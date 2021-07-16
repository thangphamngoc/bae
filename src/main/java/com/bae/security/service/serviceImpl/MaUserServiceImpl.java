package com.bae.security.service.serviceImpl;

import com.bae.security.model.UserPrincipal;
import com.bae.common.ErrorsConstant;
import com.bae.entity.user.MaUser;
import com.bae.repository.UserRepository;
import com.bae.security.request.RegisterRequest;
import com.bae.security.service.MaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * date 2021-03-24 15:02
 *
 * @author Phạm Ngọc Thắng
 */
@Service
public class MaUserServiceImpl implements MaUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        MaUser maUser = userRepository.findByUsername(username).orElseThrow();
        if (maUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.ERROR_NO_USER);
        }
        return new UserPrincipal(maUser);
    }

    @Override
    public UserDetails loadUserById(Long id) {
        // Kiểm tra xem user có tồn tại trong database không?
        MaUser maUser = userRepository.findById(id).orElseThrow();
        if (maUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.ERROR_NO_USER);
        }
        return new UserPrincipal(maUser);
    }

    @Override
    public UserDetails createAccount(RegisterRequest request) {
        Optional<MaUser> maUserOp = userRepository.findByUsername(request.getUsername());
        if (!maUserOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.ERROR_YES_USER);
        }
        MaUser maUser = new MaUser();
        maUser.setEmail(request.getEmail());
        maUser.setFirstName(request.getFirstName());
        maUser.setLastName(request.getLastName());
        maUser.setFullName(request.getFirstName() + request.getLastName());
        maUser.setUsername(request.getUsername());
        maUser.setPasswordShow(request.getPassword().trim());
        String encodedPassword = new BCryptPasswordEncoder().encode(request.getPassword().trim());
        maUser.setPassword(encodedPassword);
        maUser.setCreatedDate(LocalDateTime.now());
        maUser.setIdCreated(0l);
        userRepository.save(maUser);
        return new UserPrincipal(maUser);
    }

    @Override
    public void checkUserInMaUser(MaUser maUser) {
        if (!maUser.isDelActive()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorsConstant.ACCOUNT_DELETE);
        }
    }
}
