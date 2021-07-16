package com.bae.security.response;

import com.bae.entity.user.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * date 2021-03-24 17:05
 *
 * @author Phạm Ngọc Thắng
 */

@Getter
@Setter
public class JwtAuthenticationResponse {

    private String accessToken;

    private String tokenType = "Bearer";

//    private SchoolInforPayload schoolInfor;
//
//    private String avatar = AvatarDefaultConstant.AVATAR_SYSTEM;

    private String currentUser;

    private String appType;

    private Set<String> role;

    private Set<String> apiSet;

    @JsonIgnore
    private Set<Role> userRole;
}
