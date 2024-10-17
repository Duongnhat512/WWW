package com.iuh.se.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SinhVien {
    private Integer id;
    private String fname;
    private String lname;
    private float diemtb;

    public SinhVien(String fname, String lname, float diemtb) {
        this.fname = fname;
        this.lname = lname;
        this.diemtb = diemtb;
    }

    public SinhVien(Integer id, String fname, String lname, float diemtb) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.diemtb = diemtb;
    }
}
