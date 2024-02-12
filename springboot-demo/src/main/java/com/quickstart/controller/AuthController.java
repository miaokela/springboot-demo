package com.quickstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickstart.pojo.JwtResponse;
import com.quickstart.pojo.LoginRequest;
import com.quickstart.utils.JwtUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AuthController {
    // 注入AuthenticationManager
    // 先实现Authentication接口
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // 用户认证
            // Spring Security的AuthenticationManager会通过AuthenticationProvider
            //（通常是DaoAuthenticationProvider）间接调用UserDetailsService来加载用户信息
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));
            // 建立应用上下文
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 获取用户信息
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println(userDetails);
            
            // 颁布JWT
            String token = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error during authentication");
        }
    }

}
