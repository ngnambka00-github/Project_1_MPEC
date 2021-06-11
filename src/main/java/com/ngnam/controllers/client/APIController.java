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


    // Lấy toàn bộ sản phẩm theo upload page danh sách sản phẩm
    @GetMapping(path="/listsanpham")
    public String getListSanPham() {
        List<SanPhamDTO> listSPDTO = new ArrayList<>();
        for (SanPham sp : sanPhamService.getListSanPhamActive()) {
            listSPDTO.add(getSanPhamDTO(sp));
        }
        return new DataTransformer().dataToJson(listSPDTO);
    }

    // Lấy toàn bộ sản phẩm theo iddanhmuc
    @GetMapping(path="/listsanpham/danhmuc/{id_danh_muc}")
    public String getListSanPhamByIdDanhMuc(@PathVariable("id_danh_muc") int idDanhMuc) {
        List<SanPhamDTO> listSPDTO = new ArrayList<>();
        for (SanPham sp : sanPhamService.findSanPhamByMaDanhMuc(idDanhMuc)) {
            listSPDTO.add(getSanPhamDTO(sp));
        }
        return new DataTransformer().dataToJson(listSPDTO);
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

    @GetMapping(path="/danhmuc/{id_danh_muc}")
    public ResponseEntity<DanhMuc> getDanhMucById(@PathVariable("id_danh_muc") int idDanhMuc) {
        return new ResponseEntity<>(danhMucService.findDanhMucById(idDanhMuc), HttpStatus.OK);
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
                if (gh.getChiTietSanPham().getIdChiTietSanPham() == chiTiet.getIdChiTietSanPham()) {
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

    // Xóa / Tắng / Giảm 1 sản phẩm ở giỏ hàng
    // Type 1: Xóa
    // Type 2: Tăng
    // Type 3: Giảm
    @GetMapping(path="/customsession/{id_chi_tiet_san_pham}/{type}")
    public String customGioHangSession(HttpSession httpSession,
           @PathVariable("id_chi_tiet_san_pham") int idChiTietSanPham,
           @PathVariable("type") int type){
        List<GioHangSession> listGioHang =
                (List<GioHangSession>) httpSession.getAttribute("giohang");
        GioHangSession findObject = null;
        for (GioHangSession gh : listGioHang) {
            if (gh.getChiTietSanPham().getIdChiTietSanPham() == idChiTietSanPham) {
                findObject = gh;
                break;
            }
        }
        if (type == 1) { // type = 1: Xóa
            listGioHang.remove(findObject);
        } else if (type == 2) { // type = 2: Tăng số lượng
            findObject.setSoLuong(findObject.getSoLuong() + 1);
        } else if (type == 3) { // type = 3: Giảm số lượng
            if (findObject.getSoLuong() != 1) {
                findObject.setSoLuong(findObject.getSoLuong() - 1);
            }
        }

        // Trường hợp xóa hết k còn chiTietSanPham nào trong giỏ hàng
        if (listGioHang.size() == 0) {
            listGioHang = null;
        }

        // Cập nhập lại dữ liệu vào session
        httpSession.setAttribute("giohang", listGioHang);
        return new DataTransformer().dataToJson(listGioHang);
    }

    // Lấy ra toàn bộ danh sách danh sách trong giỏ hàng
    @GetMapping(path="/getsessiongiohang")
    public String getSessionGioHang(HttpSession httpSession) {
        List<GioHangSession> listGioHang = null;
        if (httpSession.getAttribute("giohang") != null) {
            listGioHang = (List<GioHangSession>) httpSession.getAttribute("giohang");
        }
        return new DataTransformer().dataToJson(listGioHang);
    }
}
