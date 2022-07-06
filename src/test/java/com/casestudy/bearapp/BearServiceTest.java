package com.casestudy.bearapp;

import com.casestudy.bearapp.models.Bear;
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
 class BearServiceTest {
    @Autowired
    BearService bearService;

    @Test
    void saveBear(){
        Bear bear = new Bear("Test Bear", 1,1);
        bearService.saveBear(bear);
        assertThat(bearService.getBearById(1)).isEqualTo(bear);
    }

    @Test
    void getAllBears(){
        bearService.saveBear(new Bear("Test Bear 2", 2,2));
        bearService.saveBear(new Bear("Test Bear 3", 3,3));
        List<Bear> expected = new ArrayList<>(Arrays.asList(
                new Bear(1,"Test Bear", 1,1, null, null, null, null),
                new Bear(2,"Test Bear 2", 2,2, null, null, null, null),
                new Bear(3,"Test Bear 3", 3,3, null, null, null, null)
        ));
        assertThat(bearService.getAllBears()).hasSameElementsAs(expected);
    }





}
