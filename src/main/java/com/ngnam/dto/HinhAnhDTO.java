package com.ngnam.dto;

import com.ngnam.entities.HinhAnh;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class HinhAnhDTO {
    private int idHinhAnh;
    private String tenHinhAnh;
    private String imagePath;

    public HinhAnhDTO() {

    }

    public HinhAnhDTO(HinhAnh ha) {
        this.idHinhAnh = ha.getIdHinhAnh();
        this.tenHinhAnh = ha.getTenHinhAnh();
        this.imagePath = ha.getImagePath();
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
