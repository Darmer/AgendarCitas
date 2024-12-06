package com.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entidades.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findAll();

    Optional<Doctor> findById(Long id); // Correct return type
}
