package com.iuh.se.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int maNCC;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String tenNhaCC;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String diaChi;
    private String soDienThoai;

    public NhaCungCap(int maNCC){
        this.maNCC = maNCC;
    }
}
