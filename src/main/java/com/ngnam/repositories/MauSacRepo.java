package com.ngnam.repositories;

import com.ngnam.entities.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac, Integer> {
    // Lấy tât các các màu sắc của một sản phẩm -> theo ID của sản phẩm đó
    @Query("select ms from MauSac ms " +
            "where ms.idMauSac in " +
            "(select ha.idMauSac from HinhAnh ha " +
            "where ha.idSanPham = :id_san_pham and ha.isActive = true)" +
            " and ms.isActive = true")
    public List<MauSac> findMauSacByIdSanPham(@Param("id_san_pham") int idSanPham);

    // Lấy tất cả các đối tượng MauSac mà được active = true
    @Query("select ms from MauSac ms where ms.isActive = true")
    public List<MauSac> getListMauSac();

    // Phục vụ cho việc tìm kiếm MauSac theo nội dung
    @Query("select ms from MauSac  ms where ms.isActive = true and " +
            "lower(ms.tenMauSac) like concat('%', :noi_dung, '%')")
    public List<MauSac> getListMauSacByName(@Param("noi_dung") String noiDung);

    // Lấy ra các đối tượng MauSac: có thể được active = false hoặc active = true
    @Query("select ms from MauSac  ms where ms.idMauSac = :id_mau_sac")
    public MauSac findMauSacByIdIgnoreActive(@Param("id_mau_sac") int idMauSac);
}
