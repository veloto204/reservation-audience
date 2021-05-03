package com.jazzteam.borisov.dao.builddao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.build.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AudienceDao extends GenericHibernateDao<Audience> {

    @Autowired
    public AudienceDao() {
        this.setType(Audience.class);
    }
}
