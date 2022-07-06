package com.casestudy.bearapp;


import com.casestudy.bearapp.models.User;
import com.casestudy.bearapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;



import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void saveUser(){
        User User = new User("Test User", "email@email.com", "password");
        userService.saveUser(User);
        assertThat(userService.getUserById(1)).isEqualTo(User);
    }

}
