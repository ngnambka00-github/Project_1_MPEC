package com.ngnam.service_impls;

import com.ngnam.entities.DanhMuc;
import com.ngnam.repositories.DanhMucRepo;
import com.ngnam.services.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucServiceImpls implements DanhMucService {
    @Autowired
    DanhMucRepo danhMucRepo;

    @Override
    public List<DanhMuc> getListDanhMuc() {
        return danhMucRepo.findAll();
    }

    @Override
    public DanhMuc findDanhMucById(int idDanhMuc) {
        return danhMucRepo.findDanhMucById(idDanhMuc);
    }

    @Override
    public DanhMuc findDanhMucByIdSanPham(int idSanPham) {
        return danhMucRepo.findDanhMucByIdSanPham(idSanPham);
    }
}
