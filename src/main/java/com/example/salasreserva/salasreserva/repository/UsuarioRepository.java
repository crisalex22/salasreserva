package com.example.salasreserva.salasreserva.repository;

import com.example.salasreserva.salasreserva.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
