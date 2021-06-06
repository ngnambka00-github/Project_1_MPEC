package com.ngnam.controllers.admin.API;

import com.ngnam.entities.KichThuoc;
import com.ngnam.service_impls.KichThuocServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/admin/api/kichthuoc")
public class KichThuocAPI {
    @Autowired
    KichThuocServiceImpls kichThuocService;

    // Trả về toàn bộ danh sách kích thước mà được active
    @GetMapping
    public ResponseEntity<List<KichThuoc>> getListKichThuocActive() {
        List<KichThuoc> listKichThuoc = kichThuocService.getListKichThuoc();
        return new ResponseEntity<>(listKichThuoc, HttpStatus.OK);
    }

    // Trả về list danh sách kích thước được tìm theo nội dung
    @GetMapping(path="/find/{noidung}")
    public ResponseEntity<List<KichThuoc>> findListKichThuocByContent(@PathVariable("noidung") String noiDung) {
        List<KichThuoc> listKichThuoc = kichThuocService.findListKichThuocByContent(noiDung);
        return new ResponseEntity<>(listKichThuoc, HttpStatus.OK);
    }

    // Tạo mới một đối tượng kích thước
    @PostMapping
    public ResponseEntity<KichThuoc> createNewKichThuoc(@RequestBody KichThuoc kichThuoc) {
        kichThuoc.setActive(true);
        KichThuoc newKichThuoc = kichThuocService.createNewKichThuoc(kichThuoc);
        return new ResponseEntity<>(newKichThuoc, HttpStatus.OK);
    }

    // Xóa một đối tượng kích thước theo idKichThuoc truyền vào
    @DeleteMapping(path="/{id_kich_thuoc}")
    public ResponseEntity<KichThuoc> deleteKichThuoc(@PathVariable("id_kich_thuoc") int idKichThuoc) {
        KichThuoc kichThuoc = kichThuocService.findKichThuocByIdActive(idKichThuoc);
        return new ResponseEntity<>(kichThuocService.deleteKichThuoc(kichThuoc), HttpStatus.OK);
    }

    // Update một đối tượng kichThuoc
    @PutMapping
    public ResponseEntity<KichThuoc> updateKichThuoc(@RequestBody KichThuoc kichThuoc){
        kichThuoc.setActive(true);
        return new ResponseEntity<>(kichThuocService.createNewKichThuoc(kichThuoc), HttpStatus.OK);
    }
}
