package com.ngnam.services;

import com.ngnam.entities.KichThuoc;

import java.util.List;

public interface KichThuocService {
    public List<KichThuoc> getListKichThuoc();
    public List<KichThuoc> getListKichThuocTheoIdSanPhamIdMauSac(int idSanPham, int idMauSac);
}
