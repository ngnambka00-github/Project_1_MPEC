package com.ngnam.repositories;

import com.ngnam.entities.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Integer> {
    @Query("select sp from SanPham sp where sp.danhMuc.idDanhMuc = :id_danh_muc")
    public List<SanPham> findSanPhamByMaDanhMuc(@Param("id_danh_muc") int maDanhMuc);
}
