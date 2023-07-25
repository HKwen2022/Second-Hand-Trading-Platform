package com.mymarket.controller;

import com.mymarket.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(){
        //跳转页面至用户登录界面
        return "forward:html/index.html";
    }
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(jwt);
        Map<String, Object>map = new HashMap<>();
        map.put("id", claims.get("id", Integer.class));
        map.put("name", claims.get("name", String.class));
        map.put("password", claims.get("password", String.class));
        JwtUtils.generateJwt(map, 0);
        return "forward:html/index.html";
    }
}
