package com.bt.booking.mobile.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class BookingInfo implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;
    private Long mobileId;
    private Long employeeID;

    public BookingInfo() {
    }

    public BookingInfo(Long bookingId, Long mobileId, Long employeeID) {
        this.bookingId = bookingId;
        this.mobileId = mobileId;
        this.employeeID = employeeID;
    }

}
