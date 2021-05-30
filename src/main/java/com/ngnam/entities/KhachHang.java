package com.ngnam.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="khach_hang")
@Data
public class KhachHang {
    @Id
    @Column(name="id_khach_hang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKhachHang;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="ho_ten")
    private String hoTen;

    @Column(name="email")
    private String email;

    @Column(name="dia_chi")
    private String diaChi;

    @Column(name="so_dien_thoai")
    private String soDienThoai;

    @Column(name="is_admin")
    private boolean isAdmin;

    @Column(name="is_active")
    private boolean isActive;
}
