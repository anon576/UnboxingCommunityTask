package com.example.asdf.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.asdf.Entity.AuthRequest;
import com.example.asdf.Service.JwtService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/login")
    public String addUser(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUserName());
        }else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }
    
    
}
