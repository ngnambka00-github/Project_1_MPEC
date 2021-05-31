package com.ngnam.controllers;

import com.ngnam.dto.HinhAnhDTO;
import com.ngnam.dto.KichThuocDTO;
import com.ngnam.dto.MauSacDTO;
import com.ngnam.dto.SanPhamDTO;
import com.ngnam.entities.HinhAnh;
import com.ngnam.entities.KichThuoc;
import com.ngnam.entities.MauSac;
import com.ngnam.entities.SanPham;
import com.ngnam.service_impls.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/")
public class TrangChuController {
    @Autowired
    SanPhamServiceImpls sanPhamService;

    @Autowired
    MauSacServiceImpls mauSacService;

    @Autowired
    HinhAnhServiceImpls hinhAnhService;

    @Autowired
    KichThuocServiceImpls kichThuocService;

    @Autowired
    ChiTietSanPhamServiceImpls chiTietSanPhamService;

    public SanPhamDTO getSanPhamDTO(int id) {
        SanPham sp = sanPhamService.findSanPhamById(id);
        SanPhamDTO spDTO = new SanPhamDTO(sp);
        List<MauSacDTO> listMauSac = new ArrayList<>();
        for (MauSac ms : mauSacService.findMauSacByIdSanPham(id)) {
            MauSacDTO msDTO = new MauSacDTO(ms);
            List<HinhAnhDTO> listHinhAnh = new ArrayList<>();
            for (HinhAnh ha : hinhAnhService.findHinhAnhByIdSanPhamIdMauSac(id, ms.getIdMauSac())) {
                listHinhAnh.add(new HinhAnhDTO(ha));
            }
            msDTO.setListHinhAnh(listHinhAnh);

            List<KichThuocDTO> listKichThuoc = new ArrayList<>();
            for (KichThuoc kt : kichThuocService.getListKichThuocTheoIdSanPhamIdMauSac(id, ms.getIdMauSac())) {
                KichThuocDTO ktDTO = new KichThuocDTO(kt);

                ktDTO.setSoLuong(
                        chiTietSanPhamService.getSoLuongTheoSPTheoMauSacKichThuoc(
                                id,
                                ms.getIdMauSac(),
                                kt.getIdKichThuoc()
                        ));
                listKichThuoc.add(ktDTO);
            }
            msDTO.setListKichThuoc(listKichThuoc);
            listMauSac.add(msDTO);
        };
        spDTO.setListMauSac(listMauSac);
        return spDTO;
    }

    @GetMapping
    public String getDefault() {
//        List<KichThuoc> listKichThuoc = kichThuocService.getListKichThuocTheoIdSanPhamIdMauSac(2, 6);
//        for (KichThuoc kt : listKichThuoc) {
//            System.out.println(kt.toString());
//        }
        SanPhamDTO spDTO = getSanPhamDTO(1);
        for (MauSacDTO ms : spDTO.getListMauSac()) {
            System.out.println("======================================");
            System.out.println("Ten mau sac: " + ms.getTenMauSac());
            System.out.println("Hinh anh: ");
            for (HinhAnhDTO ha : ms.getListHinhAnh()) {
                System.out.println(ha.getTenHinhAnh());
            }
            System.out.println("Size - So luong");
            for (KichThuocDTO kt : ms.getListKichThuoc()) {
                System.out.println(kt.getKyHieu() + " " + kt.getSoLuong());
            }
            System.out.println("======================================");

        }
        return "client/trang-chu";
    }
}
