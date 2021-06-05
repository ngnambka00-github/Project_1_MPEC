package com.ngnam.repositories;

import com.ngnam.entities.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac, Integer> {
    @Query("select ms from MauSac ms " +
            "where ms.idMauSac in " +
            "(select ha.idMauSac from HinhAnh ha " +
            "where ha.idSanPham = :id_san_pham and ha.isActive = true)" +
            " and ms.isActive = true")
    public List<MauSac> findMauSacByIdSanPham(@Param("id_san_pham") int idSanPham);

    @Query("select ms from MauSac ms where ms.isActive = true")
    public List<MauSac> getListMauSac();

    @Query("select ms from MauSac  ms where ms.isActive = true and " +
            "lower(ms.tenMauSac) like concat('%', :noi_dung, '%')")
    public List<MauSac> getListMauSacByName(@Param("noi_dung") String noiDung);
}
