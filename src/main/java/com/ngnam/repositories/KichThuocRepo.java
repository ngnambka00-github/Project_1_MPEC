package com.ngnam.repositories;

import com.ngnam.entities.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KichThuocRepo extends JpaRepository<KichThuoc, Integer> {
    @Query("select kt from KichThuoc kt " +
            "where kt.idKichThuoc in " +
            "(select ctsp.idKichThuoc from ChiTietSanPham ctsp " +
            "where ctsp.idSanPham = :id_san_pham and ctsp.idMauSac = :id_mau_sac)")
    public List<KichThuoc> getListKichThuocTheoIdSanPhamIdMauSac(
            @Param("id_san_pham") int idSanPham,
            @Param("id_mau_sac") int idMauSac);
}
