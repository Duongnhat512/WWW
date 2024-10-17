package com.iuh.se.dao;

import com.iuh.se.entities.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    public List<DienThoai> findAllDT();
    public DienThoai findDTById(int id);
    public DienThoai save(DienThoai dt);
    public DienThoai update(DienThoai dt);
    public boolean delete(int id);

}
