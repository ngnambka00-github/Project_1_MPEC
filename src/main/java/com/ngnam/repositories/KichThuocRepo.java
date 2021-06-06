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

    @Query("select kt from KichThuoc kt where kt.isActive = true")
    public List<KichThuoc> getListKichThuocActive();

    @Query("select kt from KichThuoc kt where kt.idKichThuoc = :id_kich_thuoc")
    public KichThuoc findKichThuocByIdIgnoreActive(@Param("id_kich_thuoc") int idKichThuoc);

    @Query("select kt from KichThuoc kt where kt.isActive = true and " +
            "lower(kt.tenKichThuoc) like concat('%', :noi_dung, '%')")
    public List<KichThuoc> findListKichThuocByContent(@Param("noi_dung") String noiDung);

    @Query("select kt from KichThuoc kt where kt.idKichThuoc = :id_kich_thuoc and " +
            "kt.isActive = true")
    public KichThuoc findKichThuocByIdActive(@Param("id_kich_thuoc") int idKichThuoc);
}
