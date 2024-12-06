package com.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.entidades.Cita;
import com.entidades.Consultorio;
import com.entidades.Doctor;

public interface CitaService {
    Cita save(Cita cita);
    List<Cita> findByDoctorAndDate(Doctor doctor, LocalDate date);
    List<Cita> findByConsultorioAndDate(Consultorio consultorio, LocalDate date);
    List<Cita> findByDate(LocalDate date);
    void cancelCita(Long id);
}
