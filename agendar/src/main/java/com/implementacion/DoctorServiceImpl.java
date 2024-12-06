package com.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entidades.Doctor;
import com.interfaces.DoctorRepository;
import com.interfaces.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
}
