package com.management.jobadvertisements1.config;
import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtil {
    private String secretKey = "secret"; // Bu anahtar daha güvenli olmalıdır.

    // Token üretme
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // 1 saat geçerlilik
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Token doğrulama
    public boolean validateToken(String token, String username) {
        String usernameFromToken = extractUsername(token);
        return (usernameFromToken.equals(username) && !isTokenExpired(token));
    }

    // Token'tan kullanıcı adı alma
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Token'ın süresinin dolup dolmadığını kontrol etme
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Token'tan son kullanma tarihini alma
    private Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

}
