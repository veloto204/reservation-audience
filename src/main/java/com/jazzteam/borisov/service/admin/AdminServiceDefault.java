package com.jazzteam.borisov.service.admin;

import com.jazzteam.borisov.models.booking.Lesson;
import com.jazzteam.borisov.models.build.Faculty;

public class AdminServiceDefault implements AdminService {

    public void setTimetable(Faculty faculty, int numberOfPairs) {
        for (int i = 1; i <= numberOfPairs; i++) {
            Lesson lesson = new Lesson();
            lesson.setFaculty(faculty);
            lesson.setNumberLesson(i);
            faculty.getLessons().add(lesson);
        }
    }
}
