package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Silla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SillaRepo extends JpaRepository<Silla, String> {

}
