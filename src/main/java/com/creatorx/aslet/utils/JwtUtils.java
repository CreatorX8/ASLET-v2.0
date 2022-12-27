package com.creatorx.aslet.utils;

import com.creatorx.aslet.dto.UserDto;
import com.creatorx.aslet.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
//    private final String secret = "NlvGEYYuumyy0OxTGN8D2bxfsICKkXAckIBtccSGTTwnXuhCbSy7zcz3zLKKfpEM3Y1yn0NcwrRcF7rJnN46CpBUzVgll8J4ythL";
    private final String secret = "ASLET";

    public String generateToken(User user) {
        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10));

        claims.put("name", user.getName());
        claims.put("email", user.getEmail());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
