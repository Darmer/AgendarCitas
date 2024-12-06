package com.implementacion;

import java.util.List;

import com.entidades.Consultorio;

public interface ConsultorioRepository {
    List<Consultorio> findAll();
    Consultorio findById(Long id);
}
