package com.ngnam.service_impls;

import com.ngnam.entities.KichThuoc;
import com.ngnam.repositories.KichThuocRepo;
import com.ngnam.services.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichThuocServiceImpls implements KichThuocService {
    @Autowired
    KichThuocRepo kichThuocRepo;

    @Override
    public List<KichThuoc> getListKichThuoc() {
        return kichThuocRepo.findAll();
    }


    @Override
    public List<KichThuoc> getListKichThuocTheoIdSanPhamIdMauSac(int idSanPham, int idMauSac) {
        return kichThuocRepo.getListKichThuocTheoIdSanPhamIdMauSac(idSanPham, idMauSac);
    }
}
