package com.jazzteam.borisov.service.personservice;

import com.jazzteam.borisov.dao.persondao.HeadOfDepartmentDao;
import com.jazzteam.borisov.models.person.HeadOfDepartment;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceHeadOdDepartment extends ServiceGeneric<HeadOfDepartment> {

    @Autowired
    public ServiceHeadOdDepartment(HeadOfDepartmentDao headOfDepartmentDao) {
        super(HeadOfDepartment.class, headOfDepartmentDao);
    }
}
