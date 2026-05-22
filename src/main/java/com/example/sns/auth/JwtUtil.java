package com.example.sns.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey secretKey;
    private final long expiration;

    // application.yaml의 값을 생성자에서 주입받아 SecretKey 객체로 변환
    public JwtUtil(
            @Value("${jwt.secret}") String secret, // 시크릿 키
            @Value("${jwt.expiration}") long expiration // 만료 시간
    ) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expiration = expiration;
    }

    // userId를 payload에 담아 토큰 생성
    public String generateToken(Long userId) {
        return Jwts.builder()
                .subject(String.valueOf(userId))   // payload의 sub에 userId 저장
                .issuedAt(new Date())              // 발급 시간
                .expiration(new Date(System.currentTimeMillis() + expiration)) // 만료 시간
                .signWith(secretKey)               // 서명
                .compact();
    }

    // 토큰에서 userId 추출
    public Long getUserId(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return Long.valueOf(claims.getSubject());
    }

    // 토큰 유효성 검증 (만료, 변조 등 확인)
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
