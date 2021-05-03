package com.jazzteam.borisov.dao.persondao;


import com.jazzteam.borisov.dao.GenericHibernateDao;
import com.jazzteam.borisov.models.person.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class TeacherDao extends GenericHibernateDao<Teacher> {

    @Autowired
    public TeacherDao() {
        this.setType(Teacher.class);
    }
}
