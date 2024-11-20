package com.iuh.se.service;

import com.iuh.se.entities.DienThoai;
import com.iuh.se.repositories.DienThoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DienThoaiService implements ServiceInterface {

    @Autowired
    private DienThoaiRepository dienThoaiRepository;

    @Override
    public List<DienThoai> getAll() {
        return dienThoaiRepository.findAll();
    }

    @Override
    public void add(DienThoai dienThoai) {
        dienThoaiRepository.save(dienThoai);
    }

    @Override
    public void delete(int maDienThoai) {
        dienThoaiRepository.deleteById((long)maDienThoai);
    }

    @Override
    public void update(DienThoai dienThoai) {
        dienThoaiRepository.save(dienThoai);
    }

    @Override
    public DienThoai getById(int maDienThoai) {
        return dienThoaiRepository.findById((long)maDienThoai).get();
    }
}
