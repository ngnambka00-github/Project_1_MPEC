package com.ngnam.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/admin/kichthuoc")
public class KichThuocController {
    @GetMapping
    public String getDefault() {
        return "/admin/kich-thuoc";
    }
}
