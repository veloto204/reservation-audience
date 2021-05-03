package com.jazzteam.borisov.service.buildservice;

import com.jazzteam.borisov.dao.builddao.DepartmentDao;
import com.jazzteam.borisov.models.build.Department;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceDepartment extends ServiceGeneric<Department> {

    @Autowired
    public ServiceDepartment(DepartmentDao departmentDao) {
        super(Department.class, departmentDao);
    }
}
