package com.casestudy.bearapp;


import com.casestudy.bearapp.models.User;
import com.casestudy.bearapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class UserServiceTest {
    @Autowired
    UserService userService;

    @Order(1)
    @Test
    void saveUser(){
        User User = new User("Test User", "email@email.com", "password");
        userService.saveUser(User);
        assertThat(userService.getUserById(1)).isEqualTo(User);
    }

    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"Test User", "Test User 2"})
    void checkUsername(String usernames){
        User user = new User("Test User 2", "email@email.com", "password");
        userService.saveUser(user);
        List<User> users = userService.getAllUsers();
        assertThat(users).extracting(User::getUsername).contains(usernames);
    }

}
