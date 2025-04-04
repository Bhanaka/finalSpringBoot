package com.wings.usermanagement.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {
    private final SecretKey secretKey ;
    //jwt token generate karanawa
    public JWTService() {
        try {
            SecretKey key = KeyGenerator.getInstance("HmacSHA256").generateKey() ;
            secretKey = Keys.hmacShaKeyFor(key.getEncoded()) ;

        } catch (Exception e) {
            throw new RuntimeException(e) ;
        }
    }
    public String getJWTToken(){
        return Jwts.builder()
                .subject("bhanaka")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() +1000*60*15))
                .signWith(secretKey)
                .compact() ;
    }
    public  String getUserName(String token){
        return Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject() ;
    }

}
