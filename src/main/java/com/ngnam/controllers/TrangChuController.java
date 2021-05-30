package com.ngnam.controllers;

import com.ngnam.entities.HinhAnh;
import com.ngnam.entities.MauSac;
import com.ngnam.service_impls.HinhAnhServiceImpls;
import com.ngnam.service_impls.MauSacServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path="/")
public class TrangChuController {
    @Autowired
    HinhAnhServiceImpls hinhAnhService;

    @Autowired
    MauSacServiceImpls mauSacService;

    @GetMapping
    public String getDefault() {
        List<MauSac> listMauSac = mauSacService.findMauSacByIdSanPham(2);
        for (MauSac ms : listMauSac) {
            System.out.println(ms.toString());
        }
        return "client/trang-chu";
    }
}
