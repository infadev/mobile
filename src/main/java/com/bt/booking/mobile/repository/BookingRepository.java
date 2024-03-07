package com.bt.booking.mobile.repository;

import com.bt.booking.mobile.entity.BookingInfo;
import com.bt.booking.mobile.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, BookingInfo> {

    @Query(value = "Select * from Booking where mobileId = :mobileId and status = :status", nativeQuery = true)
    List<Booking> readBookingByMobileId(@Param("mobileId") String mobileId, @Param("status") String status);

    @Query(value = "Select * from Booking where status = :status", nativeQuery = true)
    List<Booking> readAllActiveBooking(@Param("status") String status);

}
