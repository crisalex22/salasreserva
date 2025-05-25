package com.example.salasreserva.salasreserva.controller;

import com.example.salasreserva.salasreserva.model.Reserva;
import com.example.salasreserva.salasreserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    @PostMapping
    public Reserva crearReserva(@RequestBody Map<String, Object> datos) throws Exception {
        Long salaId = Long.valueOf(datos.get("salaId").toString());
        Long usuarioId = Long.valueOf(datos.get("usuarioId").toString());
        LocalDateTime inicio = LocalDateTime.parse(datos.get("fechaInicio").toString());
        LocalDateTime fin = LocalDateTime.parse(datos.get("fechaFin").toString());
        return reservaService.crearReserva(salaId, usuarioId, inicio, fin);
    }

    @DeleteMapping("/{id}")
    public void cancelarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
    }
}
