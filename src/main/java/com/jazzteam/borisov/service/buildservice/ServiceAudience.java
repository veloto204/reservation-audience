package com.jazzteam.borisov.service.buildservice;

import com.jazzteam.borisov.dao.builddao.AudienceDao;
import com.jazzteam.borisov.models.build.Audience;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceAudience extends ServiceGeneric<Audience> {

    @Autowired
    public ServiceAudience(AudienceDao audienceDao) {
        super(Audience.class, audienceDao);
    }
}
