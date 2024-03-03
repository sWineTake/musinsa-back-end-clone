package com.musinsa.util.config.jwt;

import com.musinsa.util.globals.GlobalProperties;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.context.annotation.Configuration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

@Configuration
public class JwtConfig {

    // 180일 * 24시간 * 60분 * 60초 * 1000밀리초
    private final long validityInMilliseconds = 180L * 24 * 60 * 60 * 1000; // 180 days for access token
    // 3일 * 24시간 * 60분 * 60초 * 1000밀리초
    private final long refreshTokenValidityInMilliseconds = 3L * 24 * 60 * 60 * 1000; // 3 days for refresh token

    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, GlobalProperties.getJwtSecurityValue())
                .compact();
    }

    public String createRefreshToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + refreshTokenValidityInMilliseconds);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, GlobalProperties.getJwtSecurityValue())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(GlobalProperties.getJwtSecurityValue()).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean isTokenExpired(String token) {
        try {
            Jwts.parser().setSigningKey(GlobalProperties.getJwtSecurityValue()).parseClaimsJws(token).getBody();
            return false;
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    public String refreshToken(String refreshToken) {
        // 리프레시 토큰으로부터 사용자 이름을 추출합니다.
        String username = extractUsername(refreshToken);
        // 새 액세스 토큰을 생성합니다.
        return createToken(username);
    }
}
