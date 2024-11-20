package com.iuh.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "dienthoai")
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDienThoai;
    @Column(columnDefinition = "nvarchar(255)")
    @NotEmpty(message = "Không được để trống")
    private String tenDienThoai;
    @Column(columnDefinition = "nvarchar(255)")
    private String diaChi;
    @NotNull(message = "Không được để trống")
    @Column(columnDefinition = "float")
    private double giaVon;
    @Column(columnDefinition = "nvarchar(255)")
    @NotEmpty(message = "Không được để trống")
    private String loai;
    @Column(columnDefinition = "nvarchar(255)")
    @NotEmpty(message = "Không được để trống")
    private String nhaCungCap;
}
