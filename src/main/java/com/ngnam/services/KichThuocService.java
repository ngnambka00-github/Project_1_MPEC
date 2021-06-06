package com.ngnam.services;

import com.ngnam.entities.KichThuoc;

import java.util.List;

public interface KichThuocService {
    public List<KichThuoc> getListKichThuoc();
    public List<KichThuoc> getListKichThuocTheoIdSanPhamIdMauSac(int idSanPham, int idMauSac);
    public List<KichThuoc> findListKichThuocByContent(String noiDung);
    public KichThuoc createNewKichThuoc(KichThuoc kichThuoc);

    public KichThuoc findKichThuocByIdActive(int idKichThuoc);
    public KichThuoc findKichThuocByIdIgnoreActive(int idKichThuoc);
    public KichThuoc deleteKichThuoc(KichThuoc kichThuoc);
}
