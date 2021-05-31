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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/sanpham")
public class SanPhamController {
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

    public SanPhamDTO getSanPhamDTO(SanPham sp) {
        int id = sp.getIdSanPham();
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
    public String getDefault(ModelMap modelMap) {
        List<SanPhamDTO> listSPDTO = new ArrayList<>();
        for (SanPham sp : sanPhamService.getListSanPham()) {
            listSPDTO.add(getSanPhamDTO(sp));
        }

        modelMap.addAttribute("listSanPham", listSPDTO);
        return "client/danh-sach-san-pham";
    }
}
