package com.example.salasreserva.salasreserva.service;

import com.example.salasreserva.salasreserva.model.Sala;
import com.example.salasreserva.salasreserva.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }
}
