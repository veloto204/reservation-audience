package com.jazzteam.borisov.service.actionservice;

import com.jazzteam.borisov.dao.action.SubjectDao;
import com.jazzteam.borisov.models.action.Subject;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceSubject extends ServiceGeneric<Subject> {

    @Autowired
    public ServiceSubject(SubjectDao subjectDao) {
        super(Subject.class, subjectDao);
    }
}
