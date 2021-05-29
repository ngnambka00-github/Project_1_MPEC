package com.ngnam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/trang-chu")
public class TrangChuController {
    @GetMapping
    public String getDefault() {
        return "trang-chu";
    }
}
