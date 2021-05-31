package com.ngnam.service_impls;

import com.ngnam.repositories.ChiTietSanPhamRepo;
import com.ngnam.services.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietSanPhamServiceImpls implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;

    @Override
    public int getSoLuongTheoSPTheoMauSacKichThuoc(int idSanPham, int idMauSac, int idKichThuoc) {
        return chiTietSanPhamRepo.getSoLuongTheoSPTheoMauSacKichThuoc(
                idSanPham,
                idMauSac,
                idKichThuoc
        );
    }
}
