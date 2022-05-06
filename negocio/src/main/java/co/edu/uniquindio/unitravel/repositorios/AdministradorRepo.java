package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdministradorRepo extends JpaRepository<Administrador, String> {

    @Query("select r from Reserva r")
    List<Reserva> obtenerReservasTotales();

    Optional<Administrador> findByEmailAndPassword(String email, String password);
}
