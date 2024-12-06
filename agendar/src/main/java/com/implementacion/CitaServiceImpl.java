package com.implementacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entidades.Cita;
import com.entidades.Consultorio;
import com.entidades.Doctor;
import com.interfaces.CitaRepository;
import com.interfaces.CitaService;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita save(Cita cita) {
        // Implement validation rules here
        return citaRepository.save(cita);
    }

    @Override
    public List<Cita> findByDoctorAndDate(Doctor doctor, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);
        return citaRepository.findByDoctorAndHorarioBetween(doctor, start, end);
    }

    @Override
    public List<Cita> findByConsultorioAndDate(Consultorio consultorio, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);
        return citaRepository.findByConsultorioAndHorarioBetween(consultorio, start, end);
    }

    @Override
    public List<Cita> findByDate(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);
        return citaRepository.findAllByHorarioBetween(start, end);
    }

    @Override
    public void cancelCita(Long id) {
        citaRepository.deleteById(id);
    }
}