package com.casestudy.bearapp;

import com.casestudy.bearapp.models.Armor;
import com.casestudy.bearapp.service.ArmorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class ArmorServiceTest {
    @Autowired
    ArmorService armorService;

    @Test
    void saveArmor(){
        Armor armor = new Armor("Test armor", 69);
        armorService.saveArmor(armor);
        assertThat(armorService.getArmorById(1)).isEqualTo(armor);
    }

}
