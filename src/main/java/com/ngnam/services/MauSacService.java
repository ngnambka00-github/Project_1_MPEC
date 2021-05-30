package com.ngnam.services;

import com.ngnam.entities.MauSac;

import java.util.List;

public interface MauSacService {
    public List<MauSac> getListMauSac();
    public List<MauSac> findMauSacByIdSanPham(int idSanPham);
}
