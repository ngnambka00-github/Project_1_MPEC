package com.ngnam.dto;

import com.ngnam.entities.MauSac;
import com.ngnam.entities.SanPham;
import com.ngnam.service_impls.MauSacServiceImpls;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDTO {
    private int idSanPham;
    private String tenSanPham;
    private DanhMucDTO danhMuc;
    private int giaSanPham;
    private int idKhuyenMai;
    private String gioiTinh;
    private String moTaSanPham;
    private String ngayNhap;
    private List<MauSacDTO> listMauSac = new ArrayList<>();

    MauSacServiceImpls mauSacService = new MauSacServiceImpls();

    public SanPhamDTO() {

    }

    public SanPhamDTO(SanPham sp) {
        this.idSanPham = sp.getIdSanPham();
        this.tenSanPham = sp.getTenSanPham();
        this.danhMuc = new DanhMucDTO(sp.getDanhMuc());
        this.giaSanPham = sp.getGiaSanPham();
        this.gioiTinh = sp.getGioiTinh();
        this.moTaSanPham = sp.getMoTaSanPham();
        this.ngayNhap = sp.getNgayNhap();
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }


    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public int getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(int idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public DanhMucDTO getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMucDTO danhMuc) {
        this.danhMuc = danhMuc;
    }

    public List<MauSacDTO> getListMauSac() {
        return listMauSac;
    }

    public void setListMauSac(List<MauSacDTO> listMauSac) {
        this.listMauSac = listMauSac;
    }

}
