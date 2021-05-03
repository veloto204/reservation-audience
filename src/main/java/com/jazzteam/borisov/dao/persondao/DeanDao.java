package com.jazzteam.borisov.dao.persondao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.person.Dean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeanDao extends GenericHibernateDao<Dean> {

    @Autowired
    public DeanDao() {
        this.setType(Dean.class);
    }
}
