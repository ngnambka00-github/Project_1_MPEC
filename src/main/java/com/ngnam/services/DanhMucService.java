package com.ngnam.services;

import com.ngnam.entities.DanhMuc;

import java.util.List;

public interface DanhMucService {
    public List<DanhMuc> getListDanhMuc();
    public DanhMuc findDanhMucById(int idDanhMuc);
}
