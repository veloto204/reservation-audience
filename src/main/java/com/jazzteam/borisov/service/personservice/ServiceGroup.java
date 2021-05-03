package com.jazzteam.borisov.service.personservice;

import com.jazzteam.borisov.dao.persondao.GroupDao;
import com.jazzteam.borisov.models.person.Group;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceGroup extends ServiceGeneric<Group> {

    @Autowired
    public ServiceGroup(GroupDao groupDao) {
        super(Group.class, groupDao);
    }
}
