package com.iuh.se.daoImpl;

import com.iuh.se.dao.DienThoaiDAO;
import com.iuh.se.entities.DienThoai;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transaction;

import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {
    private EntityManager entityManager;

    public DienThoaiDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<DienThoai> findAllDT() {
        return entityManager.createQuery("SELECT dt FROM DienThoai dt", DienThoai.class).getResultList();
    }

    @Override
    public DienThoai findDTById(int id) {
        try{
            DienThoai dt = entityManager.find(DienThoai.class, id);
            return dt;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DienThoai save(DienThoai dt) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(dt);
            entityManager.getTransaction().commit();
            return dt;
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public DienThoai update(DienThoai dt) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(dt);
            entityManager.getTransaction().commit();
            return dt;
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try{
            entityManager.getTransaction().begin();
            DienThoai dt = entityManager.find(DienThoai.class, id);
            if(dt != null){
                entityManager.remove(dt);
                entityManager.getTransaction().commit();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return false;
    }
}
