package com.ngnam.controllers.admin.API;

import com.ngnam.entities.DanhMuc;
import com.ngnam.entities.SanPham;
import com.ngnam.service_impls.DanhMucServiceImpls;
import com.ngnam.service_impls.SanPhamServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path="/admin/api/sanpham")
public class SanPhamAPI {
    @Autowired
    SanPhamServiceImpls sanPhamService;

    @Autowired
    DanhMucServiceImpls danhMucService;

    // Lấy toàn bộ sản phẩm được active
    @GetMapping
    public ResponseEntity<List<SanPham>> getListSanPhamActive() {
        List<SanPham> listSanPham = sanPhamService.getListSanPhamActive();
        return new ResponseEntity<>(listSanPham, HttpStatus.OK);
    }

    // Lấy toàn bộ sản phẩm theo id của DanhMuc
    @GetMapping(path="/theodanhmuc/{id_danh_muc}")
    public ResponseEntity<List<SanPham>> getListSanPhamTheoDanhMuc(
            @PathVariable("id_danh_muc") int idDanhMuc) {
        List<SanPham> listSanPham = sanPhamService.findSanPhamByMaDanhMuc(idDanhMuc);
        return new ResponseEntity<>(listSanPham, HttpStatus.OK);
    };

    // Tìm kiếm SanPham theo idDanhMuc và nội dung trong input[type="text"]
    @GetMapping(path="/find/{id_danh_muc}/{noi_dung}")
    public ResponseEntity<List<SanPham>> findSanPhamByIdDanhMucAndContent(
            @PathVariable("id_danh_muc") int idDanhMuc,
            @PathVariable("noi_dung") String noiDung) {
        List<SanPham> listSanPham = null;
        if (idDanhMuc == 0) { // tìm kiếm trên tất cả các DanhMuc
            listSanPham = sanPhamService.findSanPhamByContent(noiDung.toLowerCase());
        } else { // tìm kiếm trên 1 DanhMuc cụ thể
            listSanPham = sanPhamService.findSanPhamByIdDanhMucAndContent(idDanhMuc, noiDung.toLowerCase());
        }
        return new ResponseEntity<>(listSanPham, HttpStatus.OK);
    }
}
