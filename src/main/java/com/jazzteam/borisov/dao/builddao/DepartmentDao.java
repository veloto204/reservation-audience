package com.jazzteam.borisov.dao.builddao;

import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.build.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDao extends GenericHibernateDao<Department> {

    @Autowired
    public DepartmentDao() {
        this.setType(Department.class);
    }
}
