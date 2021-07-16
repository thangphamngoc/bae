package com.bae.security.jwt;

import com.bae.security.model.UserPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * date 2021-03-24 16:12
 *
 * @author Phạm Ngọc Thắng
 */
@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private long jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        Long id = userPrincipal.getMaUser().getId();
//        if (userPrincipal.getAppType().equals(AppTypeConstant.PARENT)) {
//            id = userPrincipal.getIdKidLogin();
//        } else if (userPrincipal.getAppType().equals(AppTypeConstant.TEACHER)) {
//            id = userPrincipal.getIdClassLogin();
//        } else if (userPrincipal.getAppType().equals(AppTypeConstant.SCHOOL)) {
//            id = userPrincipal.getIdSchoolLogin();
//        }
        Map<String, Object> userMap = this.getDataUserIntoToken(userPrincipal);
        return Jwts.builder()
                .setSubject(Long.toString(id))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .setId(Long.toString(id))
                .addClaims(userMap)
                .compact();
    }

    private Map<String, Object> getDataUserIntoToken(UserPrincipal principal) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("username", principal.getUsername());
        objectMap.put("passwordShow", principal.getPassword());
        objectMap.put("passwordHash", principal.getPasswordHash());
        return objectMap;
    }

    /**
     * các thông tin liên quan đến người dùng đăng nhập
     *
     * @param token
     * @return
     */
    public Claims getClaims(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    // Lấy thông tin user từ jwt
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    /**
     * lấy ra id tương ứng với appType
     * - với parent là idKid
     * - với teacher là idClass
     * - với plus là idSchool
     *
     * @param token
     * @return
     */
    public Long getIdCustom(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getId());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
