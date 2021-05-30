package com.ngnam.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="kich_thuoc")
@Data
public class KichThuoc {
    @Id
    @Column(name="id_kich_thuoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKichThuoc;

    @Column(name="ten_kich_thuoc")
    private String tenKichThuoc;

    @Column(name="ky_hieu")
    private String kyHieu;

    @Column(name="is_active")
    private boolean isActive;
}
