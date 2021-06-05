package com.ngnam.controllers.admin.API;

import com.ngnam.entities.DanhMuc;
import com.ngnam.service_impls.DanhMucServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/admin/api/danhmuc")
public class DanhMucAPI {
    @Autowired
    DanhMucServiceImpls danhMucService;

    @GetMapping
    public ResponseEntity<List<DanhMuc>> getListDanhMuc() {
        List<DanhMuc> listDanhMuc = danhMucService.getListDanhMuc();
        return new ResponseEntity<>(listDanhMuc, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DanhMuc> getDanhMucById(@PathVariable("id") int id) {
        DanhMuc dm = danhMucService.findDanhMucById(id);
        return new ResponseEntity<>(dm, HttpStatus.OK);
    }

    @GetMapping("/find/{noidung}")
    public ResponseEntity<List<DanhMuc>> getListDanhMucByName(
            @PathVariable("noidung") String noiDung) {
        List<DanhMuc> listDanhMuc = danhMucService.findDanhMucByName(noiDung.toLowerCase());
        for (DanhMuc dm : listDanhMuc) {
            if (dm.getMoTa() == null) {
                dm.setMoTa("");
            }
        }
        return new ResponseEntity<>(listDanhMuc, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DanhMuc> createNewDanhMuc(@RequestBody DanhMuc danhMuc) {
        danhMuc.setActive(true);
        DanhMuc dm = danhMucService.createNewDanhMuc(danhMuc);
        return new ResponseEntity<>(dm, HttpStatus.OK);
    }

    @DeleteMapping(path="/{id_danh_muc}")
    public ResponseEntity<DanhMuc> deleteDanhMucById(@PathVariable("id_danh_muc") int idDanhMuc) {
        DanhMuc dm = danhMucService.findDanhMucById(idDanhMuc);
        return new ResponseEntity<>(danhMucService.deleteDanhMuc(dm), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DanhMuc> updateDanhMuc(@RequestBody DanhMuc danhMuc) {
        danhMuc.setActive(true);
        return new ResponseEntity<>(danhMucService.createNewDanhMuc(danhMuc), HttpStatus.OK);
    }
}