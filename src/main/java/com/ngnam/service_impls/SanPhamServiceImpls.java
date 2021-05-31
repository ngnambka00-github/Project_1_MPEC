package com.ngnam.service_impls;

import com.ngnam.entities.SanPham;
import com.ngnam.repositories.SanPhamRepo;
import com.ngnam.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpls implements SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;

    @Override
    public List<SanPham> getListSanPham() {
        return sanPhamRepo.findAll();
    }

    @Override
    public SanPham findSanPhamById(int idSanPham) {
        return sanPhamRepo.findById(idSanPham).get();
    }

    @Override
    public List<SanPham> findSanPhamByMaDanhMuc(int idDanhMuc) {
        return sanPhamRepo.findSanPhamByMaDanhMuc(idDanhMuc);
    }
}
