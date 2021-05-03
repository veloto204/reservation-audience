package com.jazzteam.borisov.dao;

import com.jazzteam.borisov.utils.HibernateSessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GenericHibernateDao<T> {
    private static final Logger LOGGER = Logger.getLogger(GenericHibernateDao.class.getName());
    private Class<T> type;

    public GenericHibernateDao(Class<T> type) {
        this.type = type;
    }

    public GenericHibernateDao() {
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public void save(T o) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(o);
            tx1.commit();
        } catch (HibernateException e) {
            LOGGER.error(e);
        }
    }

    public void delete(T o) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(o);
            tx1.commit();
        } catch (HibernateException e) {
            LOGGER.error(e);
        }
    }

    public void delete(int entityId) {
        T entity = get(entityId);
        delete(entity);
    }

    public T get(int id) {
        T entity = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            entity = session.get(type, id);
            tx1.commit();
        } catch (HibernateException e) {
            LOGGER.error(e);
        }
        return entity;
    }

    public void update(T o) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(o);
            tx1.commit();
        } catch (HibernateException e) {
            LOGGER.error(e);
        }
    }

    public List getAll() {
        return HibernateSessionFactory.getSessionFactory().openSession().createQuery("From " + type.getName()).list();
    }
}
