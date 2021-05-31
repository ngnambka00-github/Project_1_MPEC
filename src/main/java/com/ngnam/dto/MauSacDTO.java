package com.ngnam.dto;

import com.ngnam.entities.MauSac;
import com.ngnam.entities.SanPham;
import com.ngnam.service_impls.HinhAnhServiceImpls;
import com.ngnam.service_impls.KichThuocServiceImpls;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class MauSacDTO {
    private int idMauSac;
    private String tenMauSac;
    private String maMau;
    private List<KichThuocDTO> listKichThuoc = new ArrayList<>();
    private List<HinhAnhDTO> listHinhAnh = new ArrayList<>();
    public MauSacDTO() {

    }

    public MauSacDTO(MauSac ms) {
        this.idMauSac = ms.getIdMauSac();
        this.tenMauSac = ms.getTenMauSac();
        this.maMau = ms.getMaMau();
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public List<KichThuocDTO> getListKichThuoc() {
        return listKichThuoc;
    }

    public void setListKichThuoc(List<KichThuocDTO> listKichThuoc) {
        this.listKichThuoc = listKichThuoc;
    }

    public List<HinhAnhDTO> getListHinhAnh() {
        return listHinhAnh;
    }

    public void setListHinhAnh(List<HinhAnhDTO> listHinhAnh) {
        this.listHinhAnh = listHinhAnh;
    }

    @Override
    public String toString() {
        return "MauSacDTO{" +
                "idMauSac=" + idMauSac +
                ", tenMauSac='" + tenMauSac + '\'' +
                ", maMau='" + maMau + '\'' +
                '}';
    }
}
