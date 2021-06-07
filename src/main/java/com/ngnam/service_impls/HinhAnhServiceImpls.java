package com.ngnam.service_impls;

import com.ngnam.entities.HinhAnh;
import com.ngnam.repositories.HinhAnhRepo;
import com.ngnam.services.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HinhAnhServiceImpls implements HinhAnhService {
    @Autowired private HinhAnhRepo hinhAnhRepo;

    @Override
    public List<HinhAnh> getListHinhAnh() {
        return hinhAnhRepo.findAll();
    }

    @Override
    public List<HinhAnh> findHinhAnhByIdSanPham(int idSanPham) {
        return hinhAnhRepo.findHinhAnhByIdSanPham(idSanPham);
    }

    @Override
    public List<HinhAnh> findHinhAnhByIdSanPhamIdMauSac(int idSanPham, int idMauSac) {
        return hinhAnhRepo.findHinhAnhByIdSanPhamIdMauSac(idSanPham, idMauSac);
    }
}
