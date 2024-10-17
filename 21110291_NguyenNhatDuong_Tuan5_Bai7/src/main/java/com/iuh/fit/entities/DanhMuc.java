package com.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Nguyen Nhat Duong
 * @date 27/09/2024
 */

@Entity(name = "DanhMuc")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDM", nullable = false, unique = true)
    private int maDM;
    @Column(name = "tenDanhMuc", nullable = false, columnDefinition = "nvarchar(255)")
    private String tenDanhMuc;
    @Column(name = "nguoiQuanLy", nullable = false, columnDefinition = "nvarchar(255)")
    private String nguoiQuanLy;
    @Column(name = "ghiChu", nullable = true, columnDefinition = "nvarchar(255)")
    private String ghiChu;

    public DanhMuc(int maDM) {
        this.maDM = maDM;
    }
}
