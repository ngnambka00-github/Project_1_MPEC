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

    // L???y th??ng tin ????? c???p nh???p l???i h??nh ???nh v?? k??ch th?????c t????ng ???ng v???i m???i s???n ph???m
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


    // L???y to??n b??? s???n ph???m theo upload page danh s??ch s???n ph???m
    @GetMapping(path="/listsanpham")
    public String getListSanPham() {
        List<SanPhamDTO> listSPDTO = new ArrayList<>();
        for (SanPham sp : sanPhamService.getListSanPhamActive()) {
            listSPDTO.add(getSanPhamDTO(sp));
        }
        return new DataTransformer().dataToJson(listSPDTO);
    }

    // L???y to??n b??? s???n ph???m theo iddanhmuc
    @GetMapping(path="/listsanpham/danhmuc/{id_danh_muc}")
    public String getListSanPhamByIdDanhMuc(@PathVariable("id_danh_muc") int idDanhMuc) {
        List<SanPhamDTO> listSPDTO = new ArrayList<>();
        for (SanPham sp : sanPhamService.findSanPhamByMaDanhMuc(idDanhMuc)) {
            listSPDTO.add(getSanPhamDTO(sp));
        }
        return new DataTransformer().dataToJson(listSPDTO);
    }

    // l???y to??n b??? th??ng tin s???n ph???m theo idSanPham
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

    // save session gi??? h??ng
    // => truy???n v??o idChiTietSanPham
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

            // check chiTietSanPham c?? t???n t???i trong gioHang
            boolean checkTonTai = false;
            for (GioHangSession gh : listGioHang) {
                if (gh.getChiTietSanPham().getIdChiTietSanPham() == chiTiet.getIdChiTietSanPham()) {
                    gh.setSoLuong(gh.getSoLuong() + 1);
                    checkTonTai = true;
                    break;
                }
            }
            // N???u kh??ng t???n t???i th?? th??m chiTietSanPham vao gioHang m???i
            if(!checkTonTai) {
                GioHangSession gioHang = new GioHangSession(chiTiet, 1);
                listGioHang.add(gioHang);
            }

            httpSession.setAttribute("giohang", listGioHang);
        }
        return new DataTransformer().dataToJson(listGioHang);
    }

    // X??a / T???ng / Gi???m 1 s???n ph???m ??? gi??? h??ng
    // Type 1: X??a
    // Type 2: T??ng
    // Type 3: Gi???m
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
        if (type == 1) { // type = 1: X??a
            listGioHang.remove(findObject);
        } else if (type == 2) { // type = 2: T??ng s??? l?????ng
            findObject.setSoLuong(findObject.getSoLuong() + 1);
        } else if (type == 3) { // type = 3: Gi???m s??? l?????ng
            if (findObject.getSoLuong() != 1) {
                findObject.setSoLuong(findObject.getSoLuong() - 1);
            }
        }

        // Tr?????ng h???p x??a h???t k c??n chiTietSanPham n??o trong gi??? h??ng
        if (listGioHang.size() == 0) {
            listGioHang = null;
        }

        // C???p nh???p l???i d??? li???u v??o session
        httpSession.setAttribute("giohang", listGioHang);
        return new DataTransformer().dataToJson(listGioHang);
    }

    // L???y ra to??n b??? danh s??ch danh s??ch trong gi??? h??ng
    @GetMapping(path="/getsessiongiohang")
    public String getSessionGioHang(HttpSession httpSession) {
        List<GioHangSession> listGioHang = null;
        if (httpSession.getAttribute("giohang") != null) {
            listGioHang = (List<GioHangSession>) httpSession.getAttribute("giohang");
        }
        return new DataTransformer().dataToJson(listGioHang);
    }
}
