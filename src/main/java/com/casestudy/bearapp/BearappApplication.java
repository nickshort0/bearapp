package com.casestudy.bearapp;

import com.casestudy.bearapp.data.ArmorRepository;
import com.casestudy.bearapp.data.BearRepository;
import com.casestudy.bearapp.data.WeaponRepository;
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
	public CommandLineRunner run(BearRepository brepo, WeaponRepository wrepo, ArmorRepository arepo){
		return (args -> {
			insertJavaAdvocates(brepo, wrepo, arepo);
		});
	}

	private void insertJavaAdvocates(BearRepository brepo, WeaponRepository wrepo, ArmorRepository arepo){
		brepo.save(new Bear("Bear 1", 1,1));
		brepo.save(new Bear("Bear 2", 2,2));
		brepo.save(new Bear("Bear 3", 3,3));
		brepo.save(new Bear("Bear 4", 4,4));
		brepo.save(new Bear("Bear 5", 5,5));
		brepo.save(new Bear("Bear 6", 6,6));
		brepo.save(new Bear("Bear 7", 70,100));
		for(int i = 0; i < 30; i++){
			brepo.save(new Bear("Generic Bear", 10,10));
		}
		for(int i = 0; i < 30; i++){
			wrepo.save(new Weapon("sword", 10));
		}


	}

}
