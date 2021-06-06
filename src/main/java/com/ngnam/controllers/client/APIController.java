package com.ngnam.controllers.client;

import com.ngnam.dto.HinhAnhDTO;
import com.ngnam.dto.KichThuocDTO;
import com.ngnam.dto.MauSacDTO;
import com.ngnam.dto.SanPhamDTO;
import com.ngnam.entities.*;
import com.ngnam.service_impls.*;
import com.ngnam.utils.DataTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api")
public class APIController {
    @Autowired
    SanPhamServiceImpls sanPhamService;

    @Autowired
    DanhMucServiceImpls danhMucService;

    @Autowired
    MauSacServiceImpls mauSacService;

    @Autowired
    HinhAnhServiceImpls hinhAnhService;

    @Autowired
    KichThuocServiceImpls kichThuocService;

    @Autowired
    ChiTietSanPhamServiceImpls chiTietSanPhamService;

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

    // API lấy hình ảnh từ server trả về cho giao diện
    // Lấy ảnh từ file /uploads/images/mau_san_pham (mẫu sản phẩm)
    @GetMapping(path="/getimages/{photo}")
    public ResponseEntity<ByteArrayResource> getImage(
            @PathVariable("photo") String photo) {
        // Lấy định dạng của ảnh
        String[] typeOfImage = photo.split("\\.");
        String contentType = "image/" + typeOfImage[1];

        if (!photo.isEmpty() || photo != null) {
            try {
                Path fileName = Paths.get("uploads/images/mau_san_pham/", photo);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);

                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType(contentType))
                        .body(byteArrayResource);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(path="/listdanhmuc")
    public ResponseEntity<List<DanhMuc>> getListDanhMuc() {
        List<DanhMuc> listDanhMuc = danhMucService.getListDanhMuc();
        return ResponseEntity.ok(listDanhMuc);
    }
}
