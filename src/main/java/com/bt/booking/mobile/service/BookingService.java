package com.bt.booking.mobile.service;

import com.bt.booking.mobile.entity.BookingInfo;
import com.bt.booking.mobile.entity.Booking;
import com.bt.booking.mobile.entity.Mobile;
import com.bt.booking.mobile.entity.Employee;
import com.bt.booking.mobile.exception.MobileBookingException;
import com.bt.booking.mobile.facade.BookingFacade;
import com.bt.booking.mobile.facade.MobileFacade;
import com.bt.booking.mobile.facade.EmployeeFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.bt.booking.mobile.util.ApplicationConstants.MOBILE_BOOKED;
import static com.bt.booking.mobile.util.ApplicationConstants.MOBILE_RELEASED;

@Slf4j
@Service
public class BookingService {

    @Autowired
    EmployeeFacade employeeFacade;

    @Autowired
    MobileFacade mobileFacade;

    @Autowired
    BookingFacade bookingFacade;

    public synchronized Booking bookMobile(Long mobileId, Long userId) {
        Mobile mobile = mobileFacade.findById(mobileId).orElse(null);
        Employee employee = employeeFacade.findById(userId).orElse(null);

        Booking confirmedBooking;
        if (mobile != null && mobile.getAvailableUnits() > 0 && employee != null) {
            mobile.setAvailableUnits(mobile.getAvailableUnits() - 1);
            mobileFacade.save(mobile);
            BookingInfo bookingId = new BookingInfo();
            bookingId.setMobileId(mobile.getMobileId());
            bookingId.setEmployeeID(employee.getId());
            Booking booking = new Booking(bookingId, mobile.getMobileName(), employee.getName(), LocalDate.now(), MOBILE_BOOKED);
            confirmedBooking = bookingFacade.save(booking);
            log.info(" Mobile {} booked for User {} ", mobile.getMobileName(), employee.getName());
        } else {
            throw new MobileBookingException("Issue while booking mobile. Please check inventory or employee details");
        }
        return confirmedBooking;
    }

    public Booking releaseMobile(BookingInfo bookingInfo) {

        Booking booking = bookingFacade.findById(bookingInfo).orElse(null);
        Mobile mobile = mobileFacade.findById(bookingInfo.getMobileId()).orElse(null);
        Employee employee = employeeFacade.findById(bookingInfo.getEmployeeID()).orElse(null);

        if (booking != null && mobile != null && employee != null) {
            mobile.setAvailableUnits(mobile.getAvailableUnits() + 1);
            mobileFacade.save(mobile);
            booking.setStatus(MOBILE_RELEASED);
            bookingFacade.save(booking);
            log.info(" Mobile {} released for User {} ", mobile.getMobileName(), employee.getName());
        } else {
            throw new MobileBookingException("Issue while releasing mobile. Please check inventory");
        }
        return booking;
    }

    public List<Booking> getAllActiveBookings() {
        return bookingFacade.getAllActiveBookings();
    }

    public List<Booking> getBookings() {
        return bookingFacade.getAllBookings();
    }
}
