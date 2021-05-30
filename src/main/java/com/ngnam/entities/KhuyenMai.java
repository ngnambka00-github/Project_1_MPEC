package com.ngnam.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="khuyen_mai")
@Data
public class KhuyenMai {
    @Id
    @Column(name="id_khuyen_mai")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKhuyenMai;

    @Column(name="ten_khuyen_mai")
    private String tenKhuyenMai;

    @Column(name="tien_khuyen_mai")
    private int tienKhuyenMai;

    @Column(name="thoi_gian_bat_dau")
    private String thoiGianBatDau;

    @Column(name="thoi_gian_ket_thuc")
    private String thoiGianKetThuc;

    @Column(name="is_active")
    private boolean isActive;
}
