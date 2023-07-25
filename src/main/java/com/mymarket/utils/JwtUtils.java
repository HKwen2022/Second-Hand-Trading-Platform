package com.mymarket.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String signKey = "ElPsyCongroo114514515225152231159265358979323846";
    private static final long expire = 86400000L;
    public static String generateJwt(Map<String, Object>claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }
    public static String generateJwt(Map<String, Object>claims, long expire){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }
    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(signKey).build()
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
