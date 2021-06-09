package com.ngnam.utils;

import com.ngnam.entities.ChiTietSanPham;

public class GioHangSession {
    private ChiTietSanPham sanPham;
    private int soLuong;

    public GioHangSession() {
        sanPham = null;
        soLuong = 0;
    }

    public GioHangSession(ChiTietSanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    public ChiTietSanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(ChiTietSanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
