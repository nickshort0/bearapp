package com.casestudy.bearapp;


import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.User;
import com.casestudy.bearapp.service.CustomUserDetailsService;
import com.casestudy.bearapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class CustomUserDetailsServiceTest {

    UserService userService;
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    public CustomUserDetailsServiceTest(UserService userService, CustomUserDetailsService customUserDetailsService) {
        this.userService = userService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Test
    void loadUserByUsername(){
        User user = new User("Test User", "email@email.com", "password");
        userService.saveUser(user);
        assertThat(customUserDetailsService.loadUserByUsername("Test User")).isNotNull();
    }



}
