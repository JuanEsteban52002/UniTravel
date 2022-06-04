package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertoRepo extends JpaRepository<Aeropuerto, String> {

}
