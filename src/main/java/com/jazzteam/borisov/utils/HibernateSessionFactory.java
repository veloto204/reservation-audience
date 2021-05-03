package com.jazzteam.borisov.utils;

import com.jazzteam.borisov.models.action.Subject;
import com.jazzteam.borisov.models.booking.Booking;
import com.jazzteam.borisov.models.booking.Lesson;
import com.jazzteam.borisov.models.build.Audience;
import com.jazzteam.borisov.models.build.Department;
import com.jazzteam.borisov.models.build.Faculty;
import com.jazzteam.borisov.models.build.ParameterAudience;
import com.jazzteam.borisov.models.other.TeacherHasSubject;
import com.jazzteam.borisov.models.person.Dean;
import com.jazzteam.borisov.models.person.Group;
import com.jazzteam.borisov.models.person.HeadOfDepartment;
import com.jazzteam.borisov.models.person.Teacher;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static final Logger LOGGER = Logger.getLogger(HibernateSessionFactory.class.getName());
    private static SessionFactory sessionFactory;


    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Department.class);
                configuration.addAnnotatedClass(HeadOfDepartment.class);
                configuration.addAnnotatedClass(Dean.class);
                configuration.addAnnotatedClass(Faculty.class);
                configuration.addAnnotatedClass(Subject.class);
                configuration.addAnnotatedClass(TeacherHasSubject.class);
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(Audience.class);
                configuration.addAnnotatedClass(ParameterAudience.class);
                configuration.addAnnotatedClass(Lesson.class);
                configuration.addAnnotatedClass(Booking.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
        return sessionFactory;
    }
}
