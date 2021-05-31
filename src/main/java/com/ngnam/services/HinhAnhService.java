package com.ngnam.services;

import com.ngnam.entities.HinhAnh;

import java.util.List;

public interface HinhAnhService {
    public List<HinhAnh> getListHinhAnh();
    public List<HinhAnh> findHinhAnhByIdSanPham(int idSanPham);
    public List<HinhAnh> findHinhAnhByIdSanPhamIdMauSac(int idSanPham, int idMauSac);
}
