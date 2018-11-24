package com.mdp.ourfirstproject.repository.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtilFactory {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    public static EntityManager getEntityManager()
    {
        return entityManagerFactory.createEntityManager();
    }
    private PersistenceUtilFactory(){}
}
