package com.jazzteam.borisov.service.bookingservice;

import com.jazzteam.borisov.dao.bookingdao.BookingDao;
import com.jazzteam.borisov.models.booking.Booking;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceBooking extends ServiceGeneric {
    @Autowired
    @SuppressWarnings("unchecked")
    public ServiceBooking(BookingDao bookingDao) {
        super(Booking.class, bookingDao);
    }
}
