package com.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Nguyen Nhat Duong
 * @date 27/09/2024
 */

@Entity(name = "TinTuc")
@Getter
@Setter
@ToString
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maTT", nullable = false, unique = true)
    private int maTT;
    @Column(name = "tieuDe", nullable = false, columnDefinition = "nvarchar(255)")
    private String tieuDe;
    @Column(name = "noiDungTT", nullable = false, columnDefinition = "nvarchar(255)")
    private String noiDungTT;
    @Column(name = "lienKet", nullable = false)
    private String lienKet;
    @ManyToOne
    @JoinColumn(name = "maDM", nullable = false)
    private DanhMuc danhMuc;

    public TinTuc(String tieuDe, String noiDungTT, String lienKet, DanhMuc danhMuc) {
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
        this.danhMuc = danhMuc;
    }

    public TinTuc(int maTT) {
        this.maTT = maTT;
    }

    public TinTuc(int maTT, String tieuDe, String noiDungTT, String lienKet, DanhMuc danhMuc) {
        this.maTT = maTT;
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
        this.danhMuc = danhMuc;
    }

    public TinTuc() {
    }
}
