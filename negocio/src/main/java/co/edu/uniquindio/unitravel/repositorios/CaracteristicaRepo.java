package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicaRepo extends JpaRepository<Caracteristica, Integer> {

    List<Caracteristica> findAllByTipo(Integer tipo);

    @Query("select h from Caracteristica c join c.hoteles h where c.nombre = :nombreCaracteristica")
    List<Hotel> obtenerHotelesCaracteristica(String nombreCaracteristica);


}
