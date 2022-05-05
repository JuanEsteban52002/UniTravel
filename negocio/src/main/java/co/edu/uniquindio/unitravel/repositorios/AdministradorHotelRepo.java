package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministradorHotelRepo extends JpaRepository<AdministradorHotel, String> {

    @Query("select h from Hotel h where h.administradorHotel.cedula= :codigoAdmin")
    List<Hotel> obtenerHotelesAdmin(String codigoAdmin);
}
