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
        List<DanhMuc> listDanhMuc = danhMucRepo.getListDanhMuc();
        for (DanhMuc dm : listDanhMuc) {
            if (dm.getMoTa() == null) {
                dm.setMoTa("");
            }
        }
        return listDanhMuc;
    }

    @Override
    public DanhMuc findDanhMucById(int idDanhMuc) {
        return danhMucRepo.findDanhMucById(idDanhMuc);
    }

    @Override
    public DanhMuc findDanhMucByIdSanPham(int idSanPham) {
        return danhMucRepo.findDanhMucByIdSanPham(idSanPham);
    }

    @Override
    public DanhMuc createNewDanhMuc(DanhMuc danhMuc) {
        return danhMucRepo.save(danhMuc);
    }

    @Override
    public List<DanhMuc> findDanhMucByName(String name) {
        return danhMucRepo.findDanhMucByTen(name);
    }

    @Override
    public DanhMuc deleteDanhMuc(DanhMuc danhMuc) {
        int idDanhMuc = danhMuc.getIdDanhMuc();
        danhMuc.setActive(false);
        danhMucRepo.save(danhMuc);
        return danhMucRepo.findDanhMucByIdIgnoreActive(idDanhMuc);
    }
}
