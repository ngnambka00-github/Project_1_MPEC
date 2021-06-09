package com.ngnam.controllers.client;

import com.ngnam.dto.HinhAnhDTO;
import com.ngnam.dto.KichThuocDTO;
import com.ngnam.dto.MauSacDTO;
import com.ngnam.dto.SanPhamDTO;
import com.ngnam.entities.*;
import com.ngnam.service_impls.*;
import com.ngnam.utils.DataTransformer;
import com.ngnam.utils.GioHangSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api")
public class APIController {
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

    // Lấy thông tin để cập nhập lại hình ảnh và kích thước tương ứng với mỗi sản phẩm
    @GetMapping(path="/thongtin_sp/{id_san_pham}/{id_mau_sac}")
    public String getThongTinIdSPIdMauSac(
            @PathVariable("id_san_pham") int idSanPham,
            @PathVariable("id_mau_sac") int idMauSac) {
        MauSacDTO msDTO = null;
        SanPham sp = sanPhamService.findSanPhamById(idSanPham);
        SanPhamDTO spDTO = getSanPhamDTO(sp);
        for (MauSacDTO item : spDTO.getListMauSac()) {
            if (item.getIdMauSac() == idMauSac) {
                msDTO = item;
                break;
            }
        }
        return new DataTransformer().dataToJson(msDTO);
    }

    // lấy toàn bộ thông tin sản phẩm theo idSanPham
    @GetMapping(path="/thongtin_sp/{id_san_pham}")
    public String getThongTinIdSP(@PathVariable("id_san_pham") int idSanPham) {
        SanPhamDTO sanPhamDTO = getSanPhamDTO(sanPhamService.findSanPhamById(idSanPham));
        return new DataTransformer().dataToJson(sanPhamDTO);
    }

    @GetMapping(path="/listdanhmuc")
    public ResponseEntity<List<DanhMuc>> getListDanhMuc() {
        List<DanhMuc> listDanhMuc = danhMucService.getListDanhMuc();
        return ResponseEntity.ok(listDanhMuc);
    }

    @GetMapping(path="/chitietsanpham/{id_san_pham}/{id_mau_sac}/{id_kich_thuoc}")
    public ResponseEntity<ChiTietSanPham> getChiTietSanPham(
            @PathVariable("id_san_pham") int idSanPham,
            @PathVariable("id_mau_sac") int idMauSac,
            @PathVariable("id_kich_thuoc") int idKichThuoc) {
        ChiTietSanPham ctsp = chiTietSanPhamService
                .getChiTietSanPham(idSanPham, idMauSac, idKichThuoc);
        return new ResponseEntity<>(ctsp, HttpStatus.OK);
    }

    // save session giỏ hàng
    // => truyền vào idChiTietSanPham
    @GetMapping(path="/savesession/{id_chi_tiet_san_pham}")
    public String saveGioHangSession(HttpSession httpSession,
         @PathVariable("id_chi_tiet_san_pham") int idChiTietSanPham) {

        List<GioHangSession> listGioHang = null;

        if (httpSession.getAttribute("giohang") == null) {
            listGioHang = new ArrayList<>();

            ChiTietSanPham chiTiet = chiTietSanPhamService.getChiTietSanPham(idChiTietSanPham);
            GioHangSession gioHang = new GioHangSession(chiTiet, 1);
            listGioHang.add(gioHang);

            httpSession.setAttribute("giohang", listGioHang);
        } else {
            listGioHang =
                    (List<GioHangSession>) httpSession.getAttribute("giohang");

            ChiTietSanPham chiTiet = chiTietSanPhamService.getChiTietSanPham(idChiTietSanPham);

            // check chiTietSanPham có tồn tại trong gioHang
            boolean checkTonTai = false;
            for (GioHangSession gh : listGioHang) {
                if (gh.getSanPham().getIdChiTietSanPham() == chiTiet.getIdChiTietSanPham()) {
                    gh.setSoLuong(gh.getSoLuong() + 1);
                    checkTonTai = true;
                    break;
                }
            }
            // Nếu không tồn tại thì thêm chiTietSanPham vao gioHang mới
            if(!checkTonTai) {
                GioHangSession gioHang = new GioHangSession(chiTiet, 1);
                listGioHang.add(gioHang);
            }

            httpSession.setAttribute("giohang", listGioHang);
        }
        return new DataTransformer().dataToJson(listGioHang);
    }

    @GetMapping(path="/getsessiongiohang")
    public String getSessionGioHang(HttpSession httpSession) {
        List<GioHangSession> listGioHang = null;
        if (httpSession.getAttribute("giohang") != null) {
            listGioHang = (List<GioHangSession>) httpSession.getAttribute("giohang");
        }
        return new DataTransformer().dataToJson(listGioHang);
    }
}
