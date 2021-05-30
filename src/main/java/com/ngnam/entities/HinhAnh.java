package com.ngnam.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="hinh_anh")
@Data
public class HinhAnh {
    @Id
    @Column(name="id_hinh_anh")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHinhAnh;

    @Column(name="ten_hinh_anh")
    private String tenHinhAnh;

    @Column(name="id_san_pham")
    private int idSanPham;

    @Column(name="id_mau_sac")
    private int idMauSac;

    @Column(name="is_active")
    private boolean isActive;
}