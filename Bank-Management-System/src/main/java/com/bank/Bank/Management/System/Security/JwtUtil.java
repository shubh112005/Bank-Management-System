package com.bank.Bank.Management.System.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.Signature;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key Secret_Key= Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, Secret_Key)
                .compact();
    }

    public String extractUsername(String token){
        return Jwts.parser()
                .setSigningKey(Secret_Key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, String username){
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        Date expiration = Jwts.parser()
                .setSigningKey(Secret_Key)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}
