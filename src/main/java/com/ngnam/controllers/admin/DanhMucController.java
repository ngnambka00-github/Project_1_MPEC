package com.ngnam.controllers.admin;

import com.ngnam.entities.DanhMuc;
import com.ngnam.service_impls.DanhMucServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path="/admin/danhmuc")
public class DanhMucController {
    @Autowired private DanhMucServiceImpls danhMucService;

    @GetMapping
    public String getDefault(ModelMap modelMap) {
        List<DanhMuc> listDanhMuc = danhMucService.getListDanhMuc();
        for (DanhMuc dm : listDanhMuc) {
            if (dm.getMoTa() == null) {
                dm.setMoTa("");
            }
        }
        modelMap.addAttribute("listDanhMuc", listDanhMuc);
        return "/admin/danh-muc";
    }
}
