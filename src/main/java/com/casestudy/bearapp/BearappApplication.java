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

	@Bean
	public CommandLineRunner run(BearRepository repo){
		return (args -> {
			insertJavaAdvocates(repo);
		});
	}

	private void insertJavaAdvocates(BearRepository repo){
		repo.save(new Bear("Bear 1", 1,1));
		repo.save(new Bear("Bear 2", 2,2));
		repo.save(new Bear("Bear 3", 3,3));
		repo.save(new Bear("Bear 4", 4,4));
		repo.save(new Bear("Bear 5", 5,5));
		repo.save(new Bear("Bear 6", 6,6));
		repo.save(new Bear("Bear 7", 70,100));
		for(int i = 0; i < 30; i++){
			repo.save(new Bear("Generic Bear", 10,10));
		}


	}

}
