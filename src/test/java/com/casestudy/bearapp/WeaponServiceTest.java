package com.casestudy.bearapp;


import com.casestudy.bearapp.models.Weapon;
import com.casestudy.bearapp.service.WeaponService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;



import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class WeaponServiceTest {
    @Autowired
    WeaponService weaponService;

    @Test
    void saveWeapon(){
        Weapon weapon = new Weapon("Test Weapon", 69);
        weaponService.saveWeapon(weapon);
        assertThat(weaponService.getWeaponById(1)).isEqualTo(weapon);
    }

}
