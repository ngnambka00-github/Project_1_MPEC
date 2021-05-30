package com.ngnam.service_impls;

import com.ngnam.entities.KhachHang;
import com.ngnam.repositories.KhachHangRepo;
import com.ngnam.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpls implements KhachHangService {
    @Autowired
    KhachHangRepo khachHangRepo;

    @Override
    public List<KhachHang> getListKhachHang() {
        return khachHangRepo.findAll();
    }
}
