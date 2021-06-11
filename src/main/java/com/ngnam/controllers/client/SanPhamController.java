package com.ngnam.controllers.client;

import com.ngnam.dto.HinhAnhDTO;
import com.ngnam.dto.KichThuocDTO;
import com.ngnam.dto.MauSacDTO;
import com.ngnam.dto.SanPhamDTO;
import com.ngnam.entities.*;
import com.ngnam.service_impls.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/sanpham")
public class SanPhamController {
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

    @GetMapping
    public String getDefault() { return "/client/all-san-pham"; }

    @GetMapping(path="/danhmuc/{id_danh_muc}")
    public String getSanPhamByIdDanhMuc() { return "/client/san-pham-theo-danh-muc"; }

    // Xem chi tiết của một sản phẩm
    @GetMapping(path="/chitiet/{id_san_pham}")
    public String getChiTietSanPham(
            @PathVariable("id_san_pham") int idSanPham,
            ModelMap modelMap) {
        SanPham sp = sanPhamService.findSanPhamById(idSanPham);
        SanPhamDTO spDTO = getSanPhamDTO(sp);

        DanhMuc dm = danhMucService.findDanhMucByIdSanPham(idSanPham);

        modelMap.addAttribute("sanPham", spDTO);
        modelMap.addAttribute("danhMuc", dm);
        return "/client/chi-tiet-san-pham";
    }

    // Chuyển sang trang giỏ hàng - đặt hàng
    @GetMapping(path="/dathang")
    public String viewDatHang() {
        return "/client/dat-hang";
    }
}
