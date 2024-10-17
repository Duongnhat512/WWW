package com.iuh.se.controllers;

import com.iuh.se.entities.SinhVien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {
    private List <SinhVien> list;
    int count = 5;

    public SinhVienController() {
        list = new ArrayList<>();
        list.add(new SinhVien(1, "A", "Nguyen Van", 1));
        list.add(new SinhVien(2, "B", "Nguyen Van", 2));
        list.add(new SinhVien(3, "C", "Nguyen Van", 3));
        list.add(new SinhVien(4, "D", "Nguyen Van", 4));
        list.add(new SinhVien(5, "E", "Nguyen Van", 5));
    }

    @RequestMapping("/sinhvienform")
    public ModelAndView showForm(){
        return new ModelAndView("sinhvienform", "command", new SinhVien());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(SinhVien sinhVien){
        int id = count++;
        String fname = sinhVien.getFname();
        String lname = sinhVien.getLname();
        float diemtb = sinhVien.getDiemtb();

        sinhVien = new SinhVien(id, fname, lname, diemtb);
        list.add(sinhVien);
        return new ModelAndView("viewsinhvien", "list", list);
    }

    @RequestMapping("/viewsinhvien")
    public ModelAndView viewStudent(){
        return new ModelAndView("viewsinhvien", "list", list);
    }
}
