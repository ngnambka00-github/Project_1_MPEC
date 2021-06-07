package com.ngnam.controllers.admin;

import com.ngnam.entities.MauSac;
import com.ngnam.service_impls.MauSacServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path="/admin/mausac")
public class MauSacController {
    @Autowired private MauSacServiceImpls mauSacService;

    @GetMapping
    public String getDefault(ModelMap modelMap) {
        List<MauSac> listMauSac = mauSacService.getListMauSac();
        modelMap.addAttribute("listMauSac", listMauSac);
        return "/admin/mau-sac";
    }
}
