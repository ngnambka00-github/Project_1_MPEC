package com.ngnam.repositories;

import com.ngnam.entities.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucRepo extends JpaRepository<DanhMuc, Integer> {
    @Query("select dm from DanhMuc dm where dm.idDanhMuc = :id_danh_muc")
    public DanhMuc findDanhMucById(@Param("id_danh_muc") int idDanhMuc);
}
