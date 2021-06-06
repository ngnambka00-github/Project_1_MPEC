package com.ngnam.controllers.admin.API;

import com.ngnam.entities.MauSac;
import com.ngnam.service_impls.MauSacServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/admin/api/mausac")
public class MauSacAPI {
    @Autowired
    MauSacServiceImpls mauSacService;

    // Lấy tất cả các đối tượng màu sắc mà được active = true
    @GetMapping
    public ResponseEntity<List<MauSac>> getListMauSacActive() {
        return new ResponseEntity<>(mauSacService.getListMauSac(), HttpStatus.OK);
    }

    // Tìm kiếm màu sắc theo nội dung trong input[type="text"]
    @GetMapping(path="/find/{noidung}")
    public ResponseEntity<List<MauSac>> getListMauSacByName(@PathVariable("noidung") String noiDung) {
        List<MauSac> listMauSac = mauSacService.findListMauSacByName(noiDung.toLowerCase());
        return new ResponseEntity<>(listMauSac, HttpStatus.OK);
    }

    // Tạo mới 1 đối tượng MauSac mới
    @PostMapping
    public ResponseEntity<MauSac> createNewMauSac(@RequestBody MauSac mauSac) {
        mauSac.setActive(true);
        return new ResponseEntity<>(mauSacService.saveNewMauSac(mauSac), HttpStatus.OK);
    }

    // Xóa 1 đối tượng MauSac ra khỏi danh sách => Cho thuộc tính isActive = false
    @DeleteMapping (path="/{id_mau_sac}")
    public ResponseEntity<MauSac> deleteMauSac(@PathVariable("id_mau_sac") int idMauSac) {
        MauSac ms = mauSacService.findMauSacById(idMauSac);
        return new ResponseEntity<>(mauSacService.deleteMauSac(ms), HttpStatus.OK);
    }

    // Cập nhập lại 1 đối tượng MauSac
    @PutMapping
    public ResponseEntity<MauSac> updateMauSac(@RequestBody MauSac mauSac) {
        mauSac.setActive(true);
        return new ResponseEntity<>(mauSacService.saveNewMauSac(mauSac), HttpStatus.OK);
    }
}
