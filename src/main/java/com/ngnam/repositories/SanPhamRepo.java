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

    @Query("select sp from SanPham  sp where sp.isActive = true")
    public List<SanPham> getListSanPhamActive();

    // Tìm kiếm sản phẩm trên tất cả các danh mục
    @Query("select sp from SanPham sp where sp.isActive = true and " +
            "lower(sp.tenSanPham) like concat('%', :noi_dung, '%')")
    public List<SanPham> findSanPhamByContent(@Param("noi_dung") String noiDung);

    // Tìm kiếm sản phẩm trên 1 danh mục cụ thể
    @Query("select sp from SanPham sp where sp.danhMuc.idDanhMuc = :id_danh_muc and " +
            "sp.isActive = true and " +
            "lower(sp.tenSanPham) like concat('%', :noi_dung, '%')")
    public List<SanPham> findSanPhamByIdDanhMucAndContent(@Param("id_danh_muc") int idDanhMuc,
                                                          @Param("noi_dung") String noiDung);
}
