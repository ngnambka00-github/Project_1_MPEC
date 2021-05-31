package com.ngnam.repositories;

import com.ngnam.entities.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSanPham, Integer> {
    @Query("select ctsp.soLuong from ChiTietSanPham  ctsp " +
            "where ctsp.idSanPham = :id_san_pham " +
            "and ctsp.idMauSac = :id_mau_sac " +
            "and ctsp.idKichThuoc = :id_kich_thuoc")
    public int getSoLuongTheoSPTheoMauSacKichThuoc(
            @Param("id_san_pham") int idSanPham,
            @Param("id_mau_sac") int idMauSac,
            @Param("id_kich_thuoc") int idKichThuoc);
}
