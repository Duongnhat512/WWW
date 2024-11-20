package com.iuh.se.service;

import com.iuh.se.entities.DienThoai;

import java.util.List;

public interface ServiceInterface {
    public List<DienThoai> getAll();
    public void add(DienThoai dienThoai);
    public void delete(int maDienThoai);
    public void update(DienThoai dienThoai);
    public DienThoai getById(int maDienThoai);
}
