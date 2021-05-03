package com.jazzteam.borisov.dao.otherdao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.other.TeacherHasSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherHasSubjectDao extends GenericHibernateDao<TeacherHasSubject> {

    @Autowired
    public TeacherHasSubjectDao() {
        this.setType(TeacherHasSubject.class);
    }
}
