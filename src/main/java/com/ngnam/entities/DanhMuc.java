package com.ngnam.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="danh_muc")
@Data
public class DanhMuc {
    @Id
    @Column(name="id_danh_muc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDanhMuc;

    @Column(name="ten_danh_muc")
    private String tenDanhMuc;

    @Column(name="mo_ta")
    private String moTa;

    @Column(name="is_active")
    private boolean isActive;
}
