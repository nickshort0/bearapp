package com.casestudy.bearapp;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.service.BattleService;
import com.casestudy.bearapp.service.BearService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
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
class BattleServiceTest {
    @Autowired
    BattleService battleService;

    @Test
    void Battle(){
        Bear bear1 = new Bear("Loser Bear", 1,1);
        Bear bear2 = new Bear("Strong Bear", 20,20);

        Bear winner = battleService.battle(bear1, bear2);

        assertThat(winner).isEqualTo(bear2);
        assertThat(winner).isNotEqualTo(bear1);

    }







}
