package com.interfaces;

import java.util.List;

import com.entidades.Consultorio;

public interface ConsultorioService {
    List<Consultorio> findAll();
    Consultorio findById(Long id);
}
