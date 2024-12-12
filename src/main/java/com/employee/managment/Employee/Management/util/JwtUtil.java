package com.employee.managment.Employee.Management.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "mahsabdad12";

    public String generateToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return (Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject());
    }

    public String extractRole(String token) {
        return (String) Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("role");
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token)
                .equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(token)
                .parseClaimsJws(token)
                .getBody().getExpiration()
                .before(new Date());


    }
}