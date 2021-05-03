package com.jazzteam.borisov.service.personservice;

import com.jazzteam.borisov.dao.persondao.TeacherDao;
import com.jazzteam.borisov.models.person.Teacher;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ServiceTeacher extends ServiceGeneric<Teacher> {

    @Autowired
    public ServiceTeacher(TeacherDao teacherDao) {
        super(Teacher.class, teacherDao);
    }
}
