package com.jazzteam.borisov.service.bookingservice;

import com.jazzteam.borisov.dao.bookingdao.LessonDao;
import com.jazzteam.borisov.models.booking.Lesson;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLesson extends ServiceGeneric {
    @Autowired
    @SuppressWarnings("unchecked")
    public ServiceLesson(LessonDao lessonDao) {
        super(Lesson.class, lessonDao);
    }
}
