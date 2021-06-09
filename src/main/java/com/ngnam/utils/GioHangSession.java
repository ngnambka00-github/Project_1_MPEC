package com.ngnam.utils;

import com.ngnam.entities.ChiTietSanPham;

public class GioHangSession {
    private ChiTietSanPham chiTietSanPham;
    private int soLuong;

    public GioHangSession() {
        chiTietSanPham = null;
        soLuong = 0;
    }

    public GioHangSession(ChiTietSanPham chiTietSanPham, int soLuong) {
        this.chiTietSanPham = chiTietSanPham;
        this.soLuong = soLuong;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
