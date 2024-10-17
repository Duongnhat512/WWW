package com.iuh.fit.test;

import com.iuh.fit.dao.TinTucDao;
import com.iuh.fit.daoImpl.DanhSachTinTucQuanLy;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlserver");
        emf.close();
    }
}
