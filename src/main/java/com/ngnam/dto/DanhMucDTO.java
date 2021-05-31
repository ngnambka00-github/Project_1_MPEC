package com.ngnam.dto;

import com.ngnam.entities.DanhMuc;

public class DanhMucDTO {
    private int idDanhMuc;
    private String tenDanhMuc;
    private String moTa;

    public DanhMucDTO() { }

    public DanhMucDTO(DanhMuc dm) {
        this.idDanhMuc = dm.getIdDanhMuc();
        this.tenDanhMuc = dm.getTenDanhMuc();
        this.moTa = dm.getMoTa();
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}