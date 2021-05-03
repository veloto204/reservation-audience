package com.jazzteam.borisov.dao.action;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.action.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectDao extends GenericHibernateDao<Subject> {

    @Autowired
    public SubjectDao() {
        this.setType(Subject.class);
    }
}
