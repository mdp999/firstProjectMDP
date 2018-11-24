package com.mdp.ourfirstproject.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.lang.reflect.ParameterizedType;
import java.util.List;

abstract class GenericDao<T, K> {

    private final EntityManager em;
    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected GenericDao(EntityManager entityManager) {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.em = entityManager;
    }

    public boolean create(T entity){
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    private T get(K id)
    {
        return em.find(this.entityClass, id);
    }

    public boolean update(T entity)
    {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public boolean delete(T entity)
    {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public boolean deleteById(K id) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            T entityToRemove = get(id);
            em.remove(entityToRemove);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

//    public List<T> getAll() {
//        List<T> results = em
//                .createQuery("Select t from T t", entityClass)
//                .getResultList();
//        return results;
//    }

    public List<T> getAll() {
        List<T> results = em.createQuery("from " + entityClass.getName()).getResultList();
        return results;
    }

}
