package com.interfaces;

import java.util.List;

import com.entidades.Doctor;

public interface DoctorService {
    List<Doctor> findAll();
    Doctor findById(Long id);
}
