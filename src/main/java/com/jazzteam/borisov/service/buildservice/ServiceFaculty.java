package com.jazzteam.borisov.service.buildservice;

import com.jazzteam.borisov.dao.builddao.FacultyDao;
import com.jazzteam.borisov.models.build.Faculty;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFaculty extends ServiceGeneric<Faculty> {

    @Autowired
    public ServiceFaculty(FacultyDao facultyDao) {
        super(Faculty.class, facultyDao);
    }
}
