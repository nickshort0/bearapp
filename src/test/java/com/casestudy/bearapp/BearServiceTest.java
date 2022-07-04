package com.casestudy.bearapp;

import com.casestudy.bearapp.controllers.BearController;
import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.service.BearService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(BearController.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BearServiceTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    BearService bearService;





}
