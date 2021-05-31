package com.ngnam.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="chi_tiet_san_pham")
@Data
public class ChiTietSanPham {
    @Id
    @Column(name="id_chi_tiet_san_pham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChiTietSanPham;

    @Column(name="id_san_pham")
    private int idSanPham;

    @Column(name="id_kich_thuoc")
    private int idKichThuoc;

    @Column(name="id_mau_sac")
    private int idMauSac;

    @Column(name="so_luong")
    private int soLuong;

    @Column(name="is_active")
    private boolean isActive;
}
