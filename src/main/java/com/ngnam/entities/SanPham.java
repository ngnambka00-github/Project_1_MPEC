package com.ngnam.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="san_pham")
@Data
public class SanPham {
    @Id
    @Column(name="id_san_pham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSanPham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_danh_muc")
    private DanhMuc danhMuc;

    @Column(name="ten_san_pham")
    private String tenSanPham;

    @Column(name="gia_san_pham")
    private int giaSanPham;

    // tạm thời đặt mã khyến mãi là null
    @Column(name="id_khuyen_mai")
    private Integer idKhuyenMai;

    @Column(name="gioi_tinh")
    private String gioiTinh;

    @Column(name="mo_ta_san_pham")
    private String moTaSanPham;

    @Column(name="ngay_nhap")
    private String ngayNhap;

    @Column(name="is_active")
    private boolean isActive;

}
