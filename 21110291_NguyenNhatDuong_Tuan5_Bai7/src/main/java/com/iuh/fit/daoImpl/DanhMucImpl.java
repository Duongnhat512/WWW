package com.iuh.fit.daoImpl;

import com.iuh.fit.dao.DanhMucDao;
import com.iuh.fit.entities.DanhMuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class DanhMucImpl implements DanhMucDao {
    private EntityManager entityManager;

    public DanhMucImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("sqlserver").createEntityManager();
    }
    @Override
    public List<DanhMuc> getAll() {
        return entityManager.createQuery("from DanhMuc", DanhMuc.class).getResultList();
    }
}
