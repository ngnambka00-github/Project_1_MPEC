package com.ngnam.services;

import com.ngnam.entities.ChiTietSanPham;

public interface ChiTietSanPhamService {
    public int getSoLuongTheoSPTheoMauSacKichThuoc(int idSanPham, int idMauSac, int idKichThuoc);
    public ChiTietSanPham getChiTietSanPham(int idChiTietSanPham);
    public ChiTietSanPham getChiTietSanPham(int idSanPham, int idMauSac, int idKichThuoc);
}
