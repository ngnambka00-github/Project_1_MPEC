package com.ngnam.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chi_tiet_hoa_don")
@Data
public class ChiTietHoaDon {
    @Id
    @Column(name="id_hoa_don")
    private int idHoaDon;
    
    @Id
    @Column(name="id_chi_tiet_san_pham")
    private int idChiTietSanPham;
    
    @Column(name="so_luong")
    private int soLuong;

    @Column(name="is_active")
    private boolean isActive;
}
