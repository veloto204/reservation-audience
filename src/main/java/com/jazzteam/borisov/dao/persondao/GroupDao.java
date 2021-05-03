package com.jazzteam.borisov.dao.persondao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.person.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupDao extends GenericHibernateDao<Group> {

    @Autowired
    public GroupDao() {
        this.setType(Group.class);
    }
}
