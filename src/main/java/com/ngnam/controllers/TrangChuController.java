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

    @GetMapping
    public String getDefault() {
        List<SanPham> listSanPham = sanPhamService.findSanPhamByMaDanhMuc(1);
        for (SanPham sp : listSanPham) {
            System.out.println(sp.toString());
        }
        return "client/trang-chu";
    }
}
