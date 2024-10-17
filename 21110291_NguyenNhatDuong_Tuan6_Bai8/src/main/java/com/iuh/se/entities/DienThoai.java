package com.iuh.se.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DienThoai {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int maDT;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String tenDT;
    private int namSanXuat;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String cauHinh;
    @ManyToOne
    @JoinColumn(name = "maNCC")
    private NhaCungCap nhaCC;
}
