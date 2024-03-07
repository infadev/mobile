package com.bt.booking.mobile.controller;

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
//@WebMvcTest(BookingController.class)
@DisplayName("Given the Booking cotroller is hit")
class BookingControllerTest {

    @MockBean
    BookingController bookingControllerMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllBookingDetails() {
    }

    @Test
    void getActiveBookingDetails() {
    }

    @Test
    void bookMobile() {
    }

    @Test
    void testBookMobile() {
    }
}