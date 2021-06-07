package com.ngnam.entities;

import com.ngnam.service_impls.HinhAnhServiceImpls;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.beans.Transient;
import java.util.List;

@Entity
@Table(name="hinh_anh")
@Data
public class HinhAnh {
    @Id
    @Column(name="id_hinh_anh")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHinhAnh;

    @Column(name="ten_hinh_anh")
    private String tenHinhAnh;

    @Column(name="id_san_pham")
    private int idSanPham;

    @Column(name="id_mau_sac")
    private int idMauSac;

    @Column(name="is_active")
    private boolean isActive;

    @Transient
    public String getImagePath() {
        return "/getimages/images/mau_san_pham/" + tenHinhAnh;
    }
}
