package com.ngnam.dto;

import com.ngnam.entities.HinhAnh;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class HinhAnhDTO {
    private int idHinhAnh;
    private String tenHinhAnh;

    public HinhAnhDTO() {

    }

    public HinhAnhDTO(HinhAnh ha) {
        this.idHinhAnh = ha.getIdHinhAnh();
        this.tenHinhAnh = ha.getTenHinhAnh();
    }

    public int getIdHinhAnh() {
        return idHinhAnh;
    }

    public void setIdHinhAnh(int idHinhAnh) {
        this.idHinhAnh = idHinhAnh;
    }

    public String getTenHinhAnh() {
        return tenHinhAnh;
    }

    public void setTenHinhAnh(String tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }
}
