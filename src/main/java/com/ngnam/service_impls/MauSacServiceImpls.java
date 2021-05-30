package com.ngnam.service_impls;

import com.ngnam.entities.MauSac;
import com.ngnam.repositories.MauSacRepo;
import com.ngnam.services.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpls implements MauSacService {
    @Autowired
    MauSacRepo mauSacRepo;

    @Override
    public List<MauSac> getListMauSac() {
        return mauSacRepo.findAll();
    }

    @Override
    public List<MauSac> findMauSacByIdSanPham(int idSanPham) {
        return mauSacRepo.findMauSacByIdSanPham(idSanPham);
    }
}
