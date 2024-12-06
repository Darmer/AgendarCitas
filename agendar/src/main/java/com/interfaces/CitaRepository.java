package com.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entidades.Cita;
import com.entidades.Consultorio;
import com.entidades.Doctor;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByDoctorAndHorarioBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);
    List<Cita> findByConsultorioAndHorarioBetween(Consultorio consultorio, LocalDateTime start, LocalDateTime end);
    List<Cita> findByNombrePacienteAndHorarioBetween(String nombrePaciente, LocalDateTime start, LocalDateTime end);
    List<Cita> findByDoctorAndHorario(Doctor doctor, LocalDateTime horario);
    List<Cita> findByConsultorioAndHorario(Consultorio consultorio, LocalDateTime horario);
    List<Cita> findAllByHorarioBetween(LocalDateTime start, LocalDateTime end);
    void deleteById(Long id);
}
