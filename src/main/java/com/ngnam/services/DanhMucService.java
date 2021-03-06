package com.ngnam.services;

import com.ngnam.entities.DanhMuc;

import java.util.List;

public interface DanhMucService {
    public List<DanhMuc> getListDanhMuc();
    public DanhMuc findDanhMucById(int idDanhMuc);
    public DanhMuc findDanhMucByIdSanPham(int idSanPham);
    public DanhMuc createNewDanhMuc(DanhMuc danhMuc);
    public List<DanhMuc> findDanhMucByName(String name);
    public DanhMuc deleteDanhMuc(DanhMuc danhMuc);
}
