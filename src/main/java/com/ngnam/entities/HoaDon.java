package com.ngnam.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="hoa_don")
@Data
public class HoaDon {
    @Id
    @Column(name="id_hoa_don")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHoaDon;

    @Column(name="id_khach_hang")
    private int idKhachHang;

    @Column(name="ngay_tao")
    private String ngayTao;

    @Column(name="is_thanh_toan")
    private boolean isThanhToan;

    @Column(name="is_active")
    private boolean isActive;
}
