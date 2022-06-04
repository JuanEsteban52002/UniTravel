package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Cama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CamaRepo extends JpaRepository<Cama, Integer> {



}
