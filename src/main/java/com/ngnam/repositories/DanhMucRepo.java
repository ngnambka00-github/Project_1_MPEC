package com.ngnam.repositories;

import com.ngnam.entities.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhMucRepo extends JpaRepository<DanhMuc, Integer> {
    @Query("select dm from DanhMuc dm where dm.idDanhMuc = :id_danh_muc and dm.isActive = true")
    public DanhMuc findDanhMucById(@Param("id_danh_muc") int idDanhMuc);

    @Query("select dm from DanhMuc dm where dm.idDanhMuc = " +
            "(select sp.danhMuc.idDanhMuc from SanPham sp where sp.idSanPham = :id_san_pham)")
    public DanhMuc findDanhMucByIdSanPham(@Param("id_san_pham") int idSanPham);

    @Query("select dm from DanhMuc dm where dm.isActive = true")
    public List<DanhMuc> getListDanhMuc();

    @Query("select dm from DanhMuc dm where dm.isActive = true and " +
            "lower(dm.tenDanhMuc) like concat('%', :ten_danh_muc, '%')")
    public List<DanhMuc> findDanhMucByTen(@Param("ten_danh_muc") String tenDanhMuc);

    @Modifying
    @Query("update DanhMuc dm set dm.isActive = false where dm.idDanhMuc = :id_danh_muc")
    public void deleteDanhMucById(@Param("id_danh_muc") int idDanhMuc);

    @Query("select dm from DanhMuc dm where dm.idDanhMuc = :id_danh_muc")
    public DanhMuc findDanhMucByIdIgnoreActive(@Param("id_danh_muc") int idDanhMuc);
}
