package com.ngnam.service_impls;

import com.ngnam.entities.KhuyenMai;
import com.ngnam.repositories.KhuyenMaiRepo;
import com.ngnam.services.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KhuyenMaiServiceImpls implements KhuyenMaiService {
    @Autowired private KhuyenMaiRepo khuyenMaiRepo;

    @Override
    public List<KhuyenMai> getListKhuyenMai() {
        return khuyenMaiRepo.findAll();
    }
}
