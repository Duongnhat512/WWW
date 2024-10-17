package com.iuh.fit.dao;

import com.iuh.fit.entities.TinTuc;

import java.util.List;

public interface TinTucDao {
    public List<TinTuc> getTinTucTheoDanhMuc(int idDM);
    public List<TinTuc> getAll();
    public void themTinTuc(TinTuc tinTuc);
    public boolean xoaTinTuc(int id);
}
