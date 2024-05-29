package com.example.asdf.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.asdf.Entity.UserInfo;
import com.example.asdf.Service.UserInfoSerivce;


@RestController
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    

    @Autowired
    private UserInfoSerivce userInfoSerivce;
    @Autowired
    


    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Security tutorials !!";
    }


    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        return userInfoSerivce.addUser(userInfo);
    }


    @GetMapping("/getUsers")
    public List<UserInfo> getAllUsers(){
        return userInfoSerivce.getAllUser();
    }
    
    @GetMapping("/getUsers/{id}")
    public UserInfo getAllUsers(@PathVariable Integer id){
        return userInfoSerivce.getUser(id);
    }

    

}
