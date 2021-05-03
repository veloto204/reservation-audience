package com.jazzteam.borisov.service;

import com.jazzteam.borisov.dao.GenericHibernateDao;

import java.util.List;

public class ServiceGeneric<T> {
    private Class<T> type;
    private GenericHibernateDao genericHibernateDao;

    @SuppressWarnings("unchecked")
    public ServiceGeneric(Class<T> type, GenericHibernateDao genericHibernateDao) {
        this.type = type;
        this.genericHibernateDao = genericHibernateDao;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public GenericHibernateDao getGenericHibernateDao() {
        return genericHibernateDao;
    }

    public void setGenericHibernateDao(GenericHibernateDao genericHibernateDao) {
        this.genericHibernateDao = genericHibernateDao;
    }

    @SuppressWarnings("unchecked")
    public T find(int id) {
        return (T) genericHibernateDao.get(id);
    }

    @SuppressWarnings("unchecked")
    public void save(T o) {
        genericHibernateDao.save(o);
    }

    public void delete(int id) {
        genericHibernateDao.delete(id);
    }

    @SuppressWarnings("unchecked")
    public void update(T o) {
        genericHibernateDao.update(o);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return genericHibernateDao.getAll();
    }

}
