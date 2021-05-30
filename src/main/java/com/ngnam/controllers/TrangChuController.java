package com.ngnam.controllers;

import com.ngnam.entities.DanhMuc;
import com.ngnam.service_impls.DanhMucServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path="/")
public class TrangChuController {
    @Autowired
    DanhMucServiceImpls danhMucService;

    @GetMapping
    public String getDefault() {
        List<DanhMuc> listDanhMuc = danhMucService.getListDanhMuc();
        for (DanhMuc dm : listDanhMuc) {
            System.out.println(dm.toString());
        }
        return "client/trang-chu";
    }
}
