package com.ngnam.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="mau_sac")
@Data
public class MauSac {
    @Id
    @Column(name="id_mau_sac")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMauSac;

    @Column(name="ten_mau_sac")
    private String tenMauSac;

    @Column(name="ma_mau")
    private String maMau;

    @Column(name="is_active")
    private boolean isActive;
}
