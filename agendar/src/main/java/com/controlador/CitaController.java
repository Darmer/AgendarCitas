package com.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Cita;
import com.entidades.Consultorio;
import com.entidades.Doctor;
import com.interfaces.CitaService;
import com.interfaces.ConsultorioService;
import com.interfaces.DoctorService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @Autowired
    private DoctorService doctorService; // Injecting DoctorService

    @Autowired
    private ConsultorioService consultorioService; // Injecting ConsultorioService

    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita savedCita = citaService.save(cita);
        return ResponseEntity.ok(savedCita);
    }

    @GetMapping("/doctor/{doctorId}/date/{date}")
    public ResponseEntity<List<Cita>> getCitasByDoctorAndDate(@PathVariable Long doctorId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Doctor doctor = doctorService.findById(doctorId);
        List<Cita> citas = citaService.findByDoctorAndDate(doctor, date);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/consultorio/{consultorioId}/date/{date}")
    public ResponseEntity<List<Cita>> getCitasByConsultorioAndDate(@PathVariable Long consultorioId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Consultorio consultorio = consultorioService.findById(consultorioId);
        List<Cita> citas = citaService.findByConsultorioAndDate(consultorio, date);
        return ResponseEntity.ok(citas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelCita(@PathVariable Long id) {
        citaService.cancelCita(id);
        return ResponseEntity.noContent().build();
    }
}