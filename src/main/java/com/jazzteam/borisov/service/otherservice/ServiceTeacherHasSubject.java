package com.jazzteam.borisov.service.otherservice;

import com.jazzteam.borisov.dao.otherdao.TeacherHasSubjectDao;
import com.jazzteam.borisov.models.other.TeacherHasSubject;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceTeacherHasSubject extends ServiceGeneric<TeacherHasSubject> {

    @Autowired
    public ServiceTeacherHasSubject(TeacherHasSubjectDao teacherHasSubjectDao) {
        super(TeacherHasSubject.class, teacherHasSubjectDao);
    }
}
