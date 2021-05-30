package com.ngnam.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class HinhAnhDTO {
    private int idHinhAnh;
    private String tenHinhAnh;
    private int idSanPham;
    private int idMauSac;
    private boolean isActive;
}
