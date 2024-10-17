package com.iuh.se.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EntityManagerFactoryUtil(){
        entityManagerFactory = Persistence.createEntityManagerFactory("QLDienThoai");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
