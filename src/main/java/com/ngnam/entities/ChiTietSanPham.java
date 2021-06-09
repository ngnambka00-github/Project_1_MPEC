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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_san_pham")
    private SanPham sanPham;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_kich_thuoc")
    private KichThuoc kichThuoc;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_mau_sac")
    private MauSac mauSac;

    @Column(name="so_luong")
    private int soLuong;

    @Column(name="is_active")
    private boolean isActive;

}
