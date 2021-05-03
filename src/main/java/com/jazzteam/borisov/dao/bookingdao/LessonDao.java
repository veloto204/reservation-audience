package com.jazzteam.borisov.dao.bookingdao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.booking.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LessonDao extends GenericHibernateDao<Lesson> {

    @Autowired
    public LessonDao() {
        this.setType(Lesson.class);
    }
}
