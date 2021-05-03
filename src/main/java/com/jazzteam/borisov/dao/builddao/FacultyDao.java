package com.jazzteam.borisov.dao.builddao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.build.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacultyDao extends GenericHibernateDao<Faculty> {

    @Autowired
    public FacultyDao() {
        this.setType(Faculty.class);
    }
}
