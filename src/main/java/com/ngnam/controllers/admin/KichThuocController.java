package com.ngnam.controllers.admin;

import com.ngnam.entities.KichThuoc;
import com.ngnam.service_impls.KichThuocServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path="/admin/kichthuoc")
public class KichThuocController {
    @Autowired private KichThuocServiceImpls kichThuocService;

    @GetMapping
    public String getDefault(ModelMap modelMap) {
        List<KichThuoc> listKichThuoc = kichThuocService.getListKichThuoc();
        for (KichThuoc kt : listKichThuoc) {
            if (kt.getTenKichThuoc() == null) {
                kt.setTenKichThuoc("");
            }
            if (kt.getKyHieu() == null) {
                kt.setKyHieu("");
            }
        }
        modelMap.addAttribute("listKichThuoc", listKichThuoc);
        return "/admin/kich-thuoc";
    }
}
