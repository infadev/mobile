package com.bt.booking.mobile.controller;

import com.bt.booking.mobile.entity.Booking;
import com.bt.booking.mobile.entity.BookingInfo;
import com.bt.booking.mobile.model.BookingInputVO;
import com.bt.booking.mobile.model.SuccessResponse;
import com.bt.booking.mobile.service.BookingService;
import com.bt.booking.mobile.util.ApplicationConstants;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = ApplicationConstants.DEFAULT_MAPPING,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Operation(summary = "Get all Booking information")
    @GetMapping("/bookings")
    @ResponseBody
    public ResponseEntity<Object> getAllBookingDetails() {
        List<Booking> employees = bookingService.getBookings();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(summary = "Get only active Booking information")
    @GetMapping("/activebookings")
    @ResponseBody
    public ResponseEntity<Object> getActiveBookingDetails() {
        List<Booking> employees = bookingService.getAllActiveBookings();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(summary = "Book a mobile")
    @PostMapping("/booking/new")
    @ResponseBody
    public SuccessResponse bookMobile(@Valid @RequestBody BookingInputVO bookingInputVO) {
        Booking booking = bookingService.bookMobile(bookingInputVO.getMobileID(), bookingInputVO.getEmployeeId());
        log.info("Mobile {} successfully booked for employee {}", bookingInputVO.getMobileID(), bookingInputVO.getEmployeeId());
        return new SuccessResponse(Integer.valueOf(HttpStatus.OK.value()), "Booking successful with bookingId  " + booking.getBookid().getBookingId());
    }

    @Operation(summary = "Book a mobile")
    @PostMapping("/booking/release")
    @ResponseBody
    public SuccessResponse bookMobile(@Valid @RequestBody BookingInfo bookingInfo) {
        bookingService.releaseMobile(bookingInfo);
        log.info("Mobile release {} for user {} ", bookingInfo.getMobileId(), bookingInfo.getEmployeeID());
        return new SuccessResponse(Integer.valueOf(HttpStatus.OK.value()), "Mobile successfully releases with bookingId  " + bookingInfo.getBookingId());
    }
}
