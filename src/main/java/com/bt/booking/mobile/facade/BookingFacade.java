package com.bt.booking.mobile.facade;

import com.bt.booking.mobile.entity.BookingInfo;
import com.bt.booking.mobile.entity.Booking;
import com.bt.booking.mobile.exception.MobileBookingException;
import com.bt.booking.mobile.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.bt.booking.mobile.util.ApplicationConstants.MOBILE_BOOKED;

@Slf4j
@Component
public class BookingFacade {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getAllActiveBookings() {
        List<Booking> activeBookings;
        try {
            activeBookings = bookingRepository.readAllActiveBooking(MOBILE_BOOKED);
        } catch (Exception ex) {
            log.error("Error while reading DB records");
            throw new MobileBookingException("DB read operation failed");
        }
        return activeBookings;
    }

    public List<Booking> getBookingsByMobileId(String mobileId) {
        List<Booking> bookings;
        try {
            bookings = bookingRepository.readBookingByMobileId(mobileId, MOBILE_BOOKED);
        } catch (Exception ex) {
            log.error("Error while reading DB records");
            throw new MobileBookingException("DB read operation failed");
        }
        return bookings;
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Optional<Booking> findById(BookingInfo bookingInfo) {
        return bookingRepository.findById(bookingInfo);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
