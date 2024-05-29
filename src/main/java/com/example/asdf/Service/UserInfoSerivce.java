package com.example.asdf.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.asdf.Entity.UserInfo;
import com.example.asdf.Repository.UserInfoRepository;


@Service
public class UserInfoSerivce implements UserDetailsService{

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
        
        return userInfo.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }

    public String addUser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User added successfully";
    }
    public List<UserInfo> getAllUser(){
         return userInfoRepository.findAll();
    }
    public UserInfo getUser(Integer id){
        return userInfoRepository.findById(id).get();
    }
}
