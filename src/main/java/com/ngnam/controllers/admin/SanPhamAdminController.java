package com.ngnam.controllers.admin;

import com.ngnam.dto.HinhAnhDTO;
import com.ngnam.dto.KichThuocDTO;
import com.ngnam.dto.MauSacDTO;
import com.ngnam.dto.SanPhamDTO;
import com.ngnam.entities.*;
import com.ngnam.service_impls.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SanPhamAdminController {
    @Autowired private SanPhamServiceImpls sanPhamService;

    @Autowired private DanhMucServiceImpls danhMucService;

    @Autowired private MauSacServiceImpls mauSacService;

    @Autowired private HinhAnhServiceImpls hinhAnhService;

    @Autowired private KichThuocServiceImpls kichThuocService;

    @Autowired private ChiTietSanPhamServiceImpls chiTietSanPhamService;

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
    @GetMapping(path="/admin/sanpham/themmoi")
    public String themMoiSanPham() {
        return "/admin/them-moi-san-pham";
    }

    // chi tiết sản phẩm: /admin/sanpham/chitiet/{id}
    @GetMapping(path="/admin/sanpham/chitiet/{id_san_pham}")
    public String getChiTietSanPham(
            @PathVariable("id_san_pham") int idSanPham,
            ModelMap modelMap){
        SanPham sp = sanPhamService.findSanPhamById(idSanPham);
        SanPhamDTO spDTO = getSanPhamDTO(sp);
        List<DanhMuc> listDanhMuc = danhMucService.getListDanhMuc();
        List<KichThuoc> listKichThuoc = kichThuocService.getListKichThuoc();

        modelMap.addAttribute("sanPham", spDTO);
        modelMap.addAttribute("listDanhMuc", listDanhMuc);
        modelMap.addAttribute("listKichThuoc", listKichThuoc);
        return "/admin/chi-tiet-san-pham";
    }
}
