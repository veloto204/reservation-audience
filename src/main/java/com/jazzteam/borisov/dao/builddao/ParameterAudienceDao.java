package com.jazzteam.borisov.dao.builddao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.build.ParameterAudience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParameterAudienceDao extends GenericHibernateDao<ParameterAudience> {

    @Autowired
    public ParameterAudienceDao() {
        this.setType(ParameterAudience.class);
    }
}
