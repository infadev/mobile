package com.bt.booking.mobile.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Booking {

    @EmbeddedId
    private BookingInfo bookid;

    private String mobileName;

    private String employeeName;

    private LocalDate mobileBookedDate;

    private String status;

    public Booking() {
    }

    public Booking(BookingInfo bookingId, String mobileName, @NotBlank String employeeName, LocalDate date, String status) {
        this.bookid = bookingId;
        this.mobileName = mobileName;
        this.employeeName = employeeName;
        this.mobileBookedDate = LocalDate.from(date);
        this.status = status;
    }
}
