package com.bt.booking.mobile.controller;

import com.bt.booking.mobile.facade.EmployeeFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest(EmployeeController.class)
@DisplayName("Given the Employee cotroller is hit")
class EmployeeControllerTest {

    @MockBean
    EmployeeFacade employeeFacadeMock;

    @Autowired private MockMvc mockMvc;

    @Test
    @DisplayName("")
    void getAllEmployeeDetails() {
    }

    @Test
    void addEmployeeDetails() {
    }

    @Test
    void deleteEmployee() {
    }
}