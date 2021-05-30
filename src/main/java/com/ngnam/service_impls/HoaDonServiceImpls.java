package com.ngnam.service_impls;

import com.ngnam.entities.HoaDon;
import com.ngnam.repositories.HoaDonRepo;
import com.ngnam.services.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonServiceImpls implements HoaDonService {
    @Autowired
    HoaDonRepo hoaDonRepo;

    @Override
    public List<HoaDon> getListHoaDon() {
        return hoaDonRepo.findAll();
    }
}
