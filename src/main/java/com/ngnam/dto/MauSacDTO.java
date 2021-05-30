package com.ngnam.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MauSacDTO {
    private int idMauSac;
    private String tenMauSac;
    private String maMau;
    private boolean isActive;
}
