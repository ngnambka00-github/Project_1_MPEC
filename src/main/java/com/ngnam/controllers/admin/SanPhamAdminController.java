package com.ngnam.controllers.admin;

import com.ngnam.entities.DanhMuc;
import com.ngnam.entities.SanPham;
import com.ngnam.service_impls.DanhMucServiceImpls;
import com.ngnam.service_impls.SanPhamServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SanPhamAdminController {
    @Autowired
    SanPhamServiceImpls sanPhamService;

    @Autowired
    DanhMucServiceImpls danhMucService;

    @GetMapping(path={"/admin/sanpham", "/admin"})
    public String getDefault(ModelMap modelMap) {
        List<SanPham> listSanPham = sanPhamService.getListSanPhamActive();
        List<DanhMuc> listDanhMuc = danhMucService.getListDanhMuc();

        modelMap.addAttribute("listSanPham", listSanPham);
        modelMap.addAttribute("listDanhMuc", listDanhMuc);
        return "/admin/san-pham";
    }

    // Các link khác như:
    // thêm mới: /admin/sanpham/themmoi
    // chi tiết sản phẩm: /admin/sanpham/chitiet/{id}
}
