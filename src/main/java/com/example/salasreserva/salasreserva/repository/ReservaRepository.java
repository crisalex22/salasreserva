package com.example.salasreserva.salasreserva.repository;

import com.example.salasreserva.salasreserva.model.Reserva;
import com.example.salasreserva.salasreserva.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Buscar reservas de una sala entre fechas (para evitar solapamientos)
    List<Reserva> findBySalaAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(
        Sala sala, LocalDateTime fechaFin, LocalDateTime fechaInicio);
}
