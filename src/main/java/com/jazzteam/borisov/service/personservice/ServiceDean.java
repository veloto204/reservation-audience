package com.jazzteam.borisov.service.personservice;

import com.jazzteam.borisov.dao.persondao.DeanDao;
import com.jazzteam.borisov.models.person.Dean;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceDean extends ServiceGeneric<Dean> {

    @Autowired
    public ServiceDean(DeanDao deanDao) {
        super(Dean.class, deanDao);
    }
}
