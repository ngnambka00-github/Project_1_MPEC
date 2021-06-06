package com.ngnam.services;

import com.ngnam.entities.SanPham;

import java.util.List;

public interface SanPhamService {
    public List<SanPham> getListSanPhamActive();
    public SanPham findSanPhamById(int idSanPham);
    public List<SanPham> findSanPhamByMaDanhMuc(int idDanhMuc);
    public List<SanPham> findSanPhamByContent(String noiDung);
    public List<SanPham> findSanPhamByIdDanhMucAndContent(int idDanhMuc, String noiDung);
}
