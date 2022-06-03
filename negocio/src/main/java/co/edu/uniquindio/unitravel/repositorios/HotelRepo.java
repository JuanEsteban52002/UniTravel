package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    @Query("select count(r) from Reserva r join r.reservasHabitaciones rh join rh.habitacion h join h.hotel ho where ho.codigo= :codigoHotel and r.fechaInicio <= :fechaBuscar and r.fechaFin >= :fechaBuscar")
    Integer determinarNumeroReservasHotelFecha(Integer codigoHotel, Date fechaBuscar);

    @Query ("select h from Hotel h where h.numEstrellas  = :estrellas")
    List<Hotel> obtenerHoteles(int estrellas);
// Esto sí
    List<Hotel> findAllByNumEstrellas(int estrellas);


    @Query("select co from Hotel h join h.comentarios co where h.codigo= :codigo")
    List<Comentario> obtenerComentariosHotel(int codigo);

    @Query("select distinct ho from Hotel ho join ho.habitaciones ha where ha.precio between :minValor and :maxValor")
    List<Hotel> buscarHotelesEntrePrecios(double minValor, double maxValor);

    @Query ("select h.ciudad.nombre from Hotel h where h.codigo = :codigoHotel")
    String obtenerNombreCiudad(int codigoHotel);

    @Query ("select h from Hotel h where h.ciudad.nombre = :nombreCiudad")
    List<Hotel> obtenerHotelesNombreCiudad (String nombreCiudad);

    @Query ("select h from Hotel h where h.ciudad.codigo = :codigoCiudad")
    List<Hotel> obtenerHotelesCodigoCiudad (Integer codigoCiudad);

    //Punto dos taller
    @Query("select h.ciudad.nombre, count(h) from Hotel h group by h.ciudad")
    List<Object[]> contarHotelesPorCiudad();

    //Tercer punto
    @Query("select h from Hotel h where h.comentarios is empty")
    List<Hotel> obtenerHotelSinComentarios();

    //Cuarto punto
    @Query("select h from Hotel h where lower(h.nombre) like concat('%', lower(:nombreHotel), '%') or lower(h.ciudad.nombre) like concat('%', lower(:nombreHotel), '%')")
    List<Hotel> obtenerHotelesNombre(String nombreHotel);

    //Punto nuevo taller
    @Query("select h, avg(c.calificacion) from Hotel h join h.comentarios c group by h")
    List<Object[]> obtenerCalificacionPromedioPorHotel();


    //Punto 10
    @Query("select  h from Hotel h join h.habitaciones ha where ha.precio between :precioMinimo and :precioMaximo and ha.capacidad = :cantidadPersonas ")
    List<Hotel> buscarHotelesCaracteristicas(Double precioMinimo, Double precioMaximo, int cantidadPersonas);

}


