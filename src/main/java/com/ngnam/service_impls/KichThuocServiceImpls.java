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

    // Lấy các đối tượng kích thước mà được active = true
    @Override
    public List<KichThuoc> getListKichThuoc() {
        return kichThuocRepo.getListKichThuocActive();
    }

    // Lấy danh sách đối tượng kích thước theo idSanPham và idMauSanPham
    @Override
    public List<KichThuoc> getListKichThuocTheoIdSanPhamIdMauSac(int idSanPham, int idMauSac) {
        return kichThuocRepo.getListKichThuocTheoIdSanPhamIdMauSac(idSanPham, idMauSac);
    }

    // Tìm kiếm danh sách kích thước được tìm theo nội dung bên trong input[type="text"]
    @Override
    public List<KichThuoc> findListKichThuocByContent(String noiDung) {
        return kichThuocRepo.findListKichThuocByContent(noiDung.toLowerCase());
    }

    // Tạo mới đối tượng KichThuo
    @Override
    public KichThuoc createNewKichThuoc(KichThuoc kichThuoc) {
        return kichThuocRepo.save(kichThuoc);
    }

    // Tìm kiếm KichThuoc theo idKichThuoc mà active = true
    @Override
    public KichThuoc findKichThuocByIdActive(int idKichThuoc) {
        return kichThuocRepo.findKichThuocByIdActive(idKichThuoc);
    }

    // Tìm kiếm kích thước theo idKichThuoc mà không dể ý là có active = true hay active = false
    @Override
    public KichThuoc findKichThuocByIdIgnoreActive(int idKichThuoc) {
        return kichThuocRepo.findById(idKichThuoc).get();
    }

    @Override
    public KichThuoc deleteKichThuoc(KichThuoc kichThuoc) {
        kichThuoc.setActive(false);
        return kichThuocRepo.save(kichThuoc);
    }
}
