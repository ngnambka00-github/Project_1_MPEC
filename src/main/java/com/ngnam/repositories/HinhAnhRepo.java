package com.ngnam.repositories;

import com.ngnam.entities.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HinhAnhRepo extends JpaRepository<HinhAnh, Integer> {
    @Query("select ha from HinhAnh ha where ha.idSanPham = :id_san_pham and ha.isActive = true")
    public List<HinhAnh> findHinhAnhByIdSanPham(@Param("id_san_pham") int idSanPham);
}
