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
}
