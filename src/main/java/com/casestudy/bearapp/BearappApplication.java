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
		Bear brown = new Bear("Brown Bear", 5, 5);
		brown.setImage("/assets/img/brown.jpeg");
		brown.setDescription("This is a Brown Bear");
		brepo.save(brown);

		Bear black = new Bear("Black Bear", 6, 4);
		black.setImage("/assets/img/black.jpeg");
		black.setDescription("This is a Black Bear");
		brepo.save(black);

		Bear grizzly = new Bear("Grizzly Bear", 7, 5);
		grizzly.setImage("/assets/img/grizzly.jpeg");
		grizzly.setDescription("This is a Grizzly Bear");
		brepo.save(grizzly);

		Bear kamchatka = new Bear("Kamchatka Bear", 8, 2);
		kamchatka.setImage("/assets/img/kamchatka.jpeg");
		kamchatka.setDescription("This is a Kamchatka Bear");
		brepo.save(kamchatka);

		Bear panda = new Bear("Panda Bear", 2, 20);
		panda.setImage("/assets/img/panda.jpeg");
		panda.setDescription("This is a Panda Bear");
		brepo.save(panda);

		Bear polar = new Bear("Polar Bear", 20, 20);
		polar.setImage("/assets/img/polar.jpg");
		polar.setDescription("This is a Polar Bear");
		brepo.save(polar);

		Bear teddy = new Bear("Teddy Bear", 1, 1);
		teddy.setImage("/assets/img/teddy.jpeg");
		teddy.setDescription("This is a Teddy Bear");
		brepo.save(teddy);


		brepo.save(new Bear("Bear 1", 5,5));
		brepo.save(new Bear("Bear 2", 6,6));
		brepo.save(new Bear("Bear 3", 7,7));
		brepo.save(new Bear("Bear 4", 7,7));
		brepo.save(new Bear("Bear 5", 7,7));
		brepo.save(new Bear("Bear 6", 7,7));

		for(int i = 0; i < 20; i++){
			wrepo.save(new Weapon("sword", 10));
		}
		for(int i = 0; i < 20; i++){
			arepo.save(new Armor("plate", 10));
		}


	}

}
