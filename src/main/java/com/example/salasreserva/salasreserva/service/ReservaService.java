package com.example.salasreserva.salasreserva.service;

import com.example.salasreserva.salasreserva.model.Reserva;
import com.example.salasreserva.salasreserva.model.Sala;
import com.example.salasreserva.salasreserva.model.Usuario;
import com.example.salasreserva.salasreserva.repository.ReservaRepository;
import com.example.salasreserva.salasreserva.repository.SalaRepository;
import com.example.salasreserva.salasreserva.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Reserva crearReserva(Long salaId, Long usuarioId, LocalDateTime inicio, LocalDateTime fin) throws Exception {
        Sala sala = salaRepository.findById(salaId).orElseThrow(() -> new Exception("Sala no encontrada"));
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new Exception("Usuario no encontrado"));

        // Evitar solapamientos
        List<Reserva> solapadas = reservaRepository.findBySalaAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(
                sala, fin, inicio);
        if (!solapadas.isEmpty()) {
            throw new Exception("La sala ya está reservada en ese horario");
        }

        Reserva reserva = new Reserva();
        reserva.setSala(sala);
        reserva.setUsuario(usuario);
        reserva.setFechaInicio(inicio);
        reserva.setFechaFin(fin);
        return reservaRepository.save(reserva);
    }

    public void cancelarReserva(Long reservaId) {
        reservaRepository.deleteById(reservaId);
    }
}
