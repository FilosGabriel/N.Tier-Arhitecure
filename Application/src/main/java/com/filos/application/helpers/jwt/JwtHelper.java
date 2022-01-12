package com.filos.application.helpers.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtHelper {

    private final String secretKey = "";
    private final Long days = 1L;

    @SneakyThrows
    public String generateToken(SecurityProperties.User user) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        String jwt = Jwts.builder()
                .claim("name-identifier", user.getName())
                .claim("name", user.getName())
                .claim("email", user.getName())
                .setExpiration(Date.from(LocalDateTime.now().plusDays(days).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS256, keyBytes).compact();

        return jwt;
    }
}
