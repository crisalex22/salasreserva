package com.example.salasreserva.salasreserva.controller;

import com.example.salasreserva.salasreserva.model.Sala;
import com.example.salasreserva.salasreserva.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@CrossOrigin(origins = "http://localhost:3000")
public class SalaController {
    @Autowired
    private SalaService salaService;

    @GetMapping
    public List<Sala> listarSalas() {
        return salaService.listarSalas();
    }
}
