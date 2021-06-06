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
        return mauSacRepo.getListMauSac();
    }

    @Override
    public List<MauSac> findMauSacByIdSanPham(int idSanPham) {
        return mauSacRepo.findMauSacByIdSanPham(idSanPham);
    }

    @Override
    public List<MauSac> findListMauSacByName(String noiDung) {
        return mauSacRepo.getListMauSacByName(noiDung);
    }

    @Override
    public MauSac saveNewMauSac(MauSac mauSac) {
        return mauSacRepo.save(mauSac);
    }

    @Override
    public MauSac deleteMauSac(MauSac mauSac) {
        int idMauSac = mauSac.getIdMauSac();
        mauSac.setActive(false);
        mauSacRepo.save(mauSac);
        return mauSacRepo.findMauSacByIdIgnoreActive(idMauSac);
    }

    @Override
    public MauSac findMauSacById(int idMauSac) {
        return mauSacRepo.findById(idMauSac).get();
    }
}
