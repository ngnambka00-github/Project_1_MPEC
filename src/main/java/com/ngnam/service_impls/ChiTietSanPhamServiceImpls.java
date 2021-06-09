package com.ngnam.service_impls;

import com.ngnam.entities.ChiTietSanPham;
import com.ngnam.entities.MauSac;
import com.ngnam.entities.SanPham;
import com.ngnam.repositories.ChiTietSanPhamRepo;
import com.ngnam.services.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietSanPhamServiceImpls implements ChiTietSanPhamService {
    @Autowired private ChiTietSanPhamRepo chiTietSanPhamRepo;

    @Override
    public int getSoLuongTheoSPTheoMauSacKichThuoc(int idSanPham, int idMauSac, int idKichThuoc) {
        return chiTietSanPhamRepo.getSoLuongTheoSPTheoMauSacKichThuoc(
                idSanPham,
                idMauSac,
                idKichThuoc
        );
    }

    @Override
    public ChiTietSanPham getChiTietSanPham(int idChiTietSanPham) {
        ChiTietSanPham chiTiet = chiTietSanPhamRepo.findChiTietSanPham(idChiTietSanPham);
        MauSac mauSac = chiTiet.getMauSac();
        SanPham sanPham = chiTiet.getSanPham();
        sanPham.setListHinhAnh(sanPham.getListHinhAnhByMauSac(mauSac));
        return chiTiet;
    }

    @Override
    public ChiTietSanPham getChiTietSanPham(int idSanPham, int idMauSac, int idKichThuoc) {
        ChiTietSanPham chiTiet = chiTietSanPhamRepo.findChiTietSanPham(idSanPham, idMauSac, idKichThuoc);
        MauSac mauSac = chiTiet.getMauSac();
        SanPham sanPham = chiTiet.getSanPham();
        sanPham.setListHinhAnh(sanPham.getListHinhAnhByMauSac(mauSac));
        return chiTiet;
    }
}
