package com.casestudy.bearapp;

import com.casestudy.bearapp.controllers.HomeController;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@FieldDefaults(level = AccessLevel.PRIVATE)
class BearappApplicationTests {

	@Autowired
	HomeController homeController;
	@Test
	void contextLoads() {
		assertThat(homeController).isNotNull();
	}

}
