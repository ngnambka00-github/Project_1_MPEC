package com.ngnam.dto;

import com.ngnam.entities.KichThuoc;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class KichThuocDTO {
    private int idKichThuoc;
    private String tenKichThuoc;
    private String kyHieu;
    private int soLuong;

    public KichThuocDTO() {

    }

    public KichThuocDTO(KichThuoc kt) {
        this.idKichThuoc = kt.getIdKichThuoc();
        this.tenKichThuoc = kt.getTenKichThuoc();
        this.kyHieu = kt.getKyHieu();
    }

    public int getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(int idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public String getTenKichThuoc() {
        return tenKichThuoc;
    }

    public void setTenKichThuoc(String tenKichThuoc) {
        this.tenKichThuoc = tenKichThuoc;
    }

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
