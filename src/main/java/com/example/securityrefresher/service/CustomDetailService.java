package com.example.securityrefresher.service;

import com.example.securityrefresher.domain.User;
import com.example.securityrefresher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUserName(username);
        userOptional.orElseThrow(()->new UsernameNotFoundException("Not Found: "+username));
        return userOptional.map(CustomUserDetail::new).get();
    }
}
