package com.jazzteam.borisov.service.buildservice;

import com.jazzteam.borisov.dao.builddao.ParameterAudienceDao;
import com.jazzteam.borisov.models.build.ParameterAudience;
import com.jazzteam.borisov.service.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceParameterAudience extends ServiceGeneric<ParameterAudience> {

    @Autowired
    public ServiceParameterAudience(ParameterAudienceDao parameterAudienceDao) {
        super(ParameterAudience.class, parameterAudienceDao);
    }
}
