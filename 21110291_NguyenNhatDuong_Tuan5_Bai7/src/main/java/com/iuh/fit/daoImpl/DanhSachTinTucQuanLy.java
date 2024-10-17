package com.iuh.fit.daoImpl;

import com.iuh.fit.dao.DanhMucDao;
import com.iuh.fit.dao.TinTucDao;
import com.iuh.fit.entities.DanhMuc;
import com.iuh.fit.entities.TinTuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class DanhSachTinTucQuanLy implements TinTucDao{
    private EntityManager entityManager;

    public DanhSachTinTucQuanLy(){
        this.entityManager = Persistence.createEntityManagerFactory("sqlserver").createEntityManager();
    }

    @Override
    public List<TinTuc> getTinTucTheoDanhMuc(int idDM) {
        List<TinTuc> list = entityManager.createQuery("SELECT tt FROM TinTuc tt WHERE tt.danhMuc.id = :idDM", TinTuc.class)
                .setParameter("idDM", idDM)
                .getResultList();
        return list;
    }

    @Override
    public List<TinTuc> getAll() {
        return (List<TinTuc>) entityManager.createQuery("SELECT tt FROM TinTuc tt").getResultList();
    }

    @Override
    public void themTinTuc(TinTuc tinTuc) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(tinTuc);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public boolean xoaTinTuc(int id) {
        try {
            entityManager.getTransaction().begin();
            TinTuc tinTuc = entityManager.find(TinTuc.class, id);
            entityManager.remove(tinTuc);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return false;
    }

    public void close(){
        this.entityManager.close();

    }
}
