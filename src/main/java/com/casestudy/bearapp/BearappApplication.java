package com.casestudy.bearapp;

import com.casestudy.bearapp.data.BearRepository;
import com.casestudy.bearapp.models.Armor;
import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.Weapon;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BearappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BearappApplication.class, args);
	}


}
