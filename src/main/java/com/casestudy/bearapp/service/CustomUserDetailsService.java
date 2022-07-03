package com.casestudy.bearapp.service;

import com.casestudy.bearapp.data.UserRepository;
import com.casestudy.bearapp.models.User;
import com.casestudy.bearapp.models.Weapon;
import com.casestudy.bearapp.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByUsername(username);
        User user;
        if(optional.isPresent()){
           user = optional.get();
        }
        else{
            throw new RuntimeException("User not found for username: " + username);
        }

        return new CustomUserDetails(user);
    }
}
