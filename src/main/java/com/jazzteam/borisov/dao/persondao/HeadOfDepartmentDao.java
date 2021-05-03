package com.jazzteam.borisov.dao.persondao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.person.HeadOfDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadOfDepartmentDao extends GenericHibernateDao<HeadOfDepartment> {

    @Autowired
    public HeadOfDepartmentDao() {
        this.setType(HeadOfDepartment.class);
    }
}
