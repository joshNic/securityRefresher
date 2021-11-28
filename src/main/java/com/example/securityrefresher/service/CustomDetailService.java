package com.example.securityrefresher.service;

import com.example.securityrefresher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomDetailService implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("test","test",new ArrayList<>());
//        Optional<User> userOptional = userRepository.findByUserName(username);
//        userOptional.orElseThrow(()->new UsernameNotFoundException("Not Found: "+username));
//        return userOptional.map(CustomUserDetail::new).get();
    }
}
