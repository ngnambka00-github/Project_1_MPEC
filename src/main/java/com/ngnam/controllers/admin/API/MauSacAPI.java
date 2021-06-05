package com.ngnam.controllers.admin.API;

import com.ngnam.entities.MauSac;
import com.ngnam.service_impls.MauSacServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path="/admin/api/mausac")
public class MauSacAPI {
    @Autowired
    MauSacServiceImpls mauSacService;

    @GetMapping
    public ResponseEntity<List<MauSac>> getListMauSacActive() {
        return new ResponseEntity<>(mauSacService.getListMauSac(), HttpStatus.OK);
    }

    @GetMapping(path="/find/{noidung}")
    public ResponseEntity<List<MauSac>> getListMauSacByName(@PathVariable("noidung") String noiDung) {
        List<MauSac> listMauSac = mauSacService.findListMauSacByName(noiDung.toLowerCase());
        return new ResponseEntity<>(listMauSac, HttpStatus.OK);
    }
}
