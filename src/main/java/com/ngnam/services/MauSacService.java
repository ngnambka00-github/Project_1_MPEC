package com.ngnam.services;

import com.ngnam.entities.MauSac;

import java.util.List;

public interface MauSacService {
    public List<MauSac> getListMauSac();
    public List<MauSac> findMauSacByIdSanPham(int idSanPham);
    public List<MauSac> findListMauSacByName(String noiDung);
    public MauSac saveNewMauSac(MauSac mauSac);
    public MauSac deleteMauSac(MauSac mauSac);
    public MauSac findMauSacById(int idMauSac);
}
