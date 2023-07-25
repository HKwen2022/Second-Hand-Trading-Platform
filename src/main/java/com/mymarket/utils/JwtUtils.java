package com.mymarket.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

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
    public static Integer[] checkToken(HttpServletRequest request) {
        Integer[] res = new Integer[2];     //{用户类型，id}
        String jwt = request.getHeader("token");
        System.out.println("token: "+jwt);
        if(!StringUtils.hasLength(jwt)){
            res[0] = -1;
        }
        Claims claims;
        try {
            claims = JwtUtils.parseJwt(jwt);
            res[0] = claims.get("type", Integer.class);
            res[1] = claims.get("id", Integer.class);
        }catch (Exception e){
            e.printStackTrace();
            res[0] = -1;
        }
        /*
        type == 0 ---> 用户
        type == 1 ---> 管理员
         */
        return res;
    }
    public static boolean check(Integer id, HttpServletRequest request){
        return !Objects.equals(JwtUtils.checkToken(request)[1], id);
    }
}