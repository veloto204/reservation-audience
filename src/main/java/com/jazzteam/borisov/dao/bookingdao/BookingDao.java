package com.jazzteam.borisov.dao.bookingdao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.booking.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingDao extends GenericHibernateDao<Booking> {

    @Autowired
    public BookingDao() {
        this.setType(Booking.class);
    }
}
