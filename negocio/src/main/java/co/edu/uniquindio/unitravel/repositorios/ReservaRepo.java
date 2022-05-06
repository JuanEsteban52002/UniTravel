package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.ReservaHabitacion;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.entidades.dto.ReservaDTO;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservaRepo extends JpaRepository<Reserva, String> {

    @Query("select ha from Reserva r join r.reservasHabitaciones rh join rh.habitacion ha where r.fechaInicio <= :fechaMin and r.fechaFin >= :fechaMax")
    List<Habitacion> obtenerHabitacionesDisponiblesFechas(Date fechaMin, Date fechaMax);

    //Manito
    @Query("select v from Reserva r join r.reservasSillas rs join rs.silla s join s.vuelo v where v.codigo = :codigoVuelo")
    Vuelo seleccionVueloSegunCodigo(String codigoVuelo);
    //Manito
    @Query("select r.reservasHabitaciones from Reserva r")
    List<ReservaHabitacion> habitacionesReservadas();

    @Query("select r from Reserva r where r.fechaInicio >= :fechaMin and r.fechaFin <= :fechaMax")
    List<Reserva> devolverReservaIntervaloFecha(Date fechaMin, Date fechaMax);

    @Query("select r.cliente.nombre, r.fechaReserva, h.habitacion from Reserva r join r.reservasHabitaciones h where h.habitacion.hotel.codigo = :id and r.fechaInicio < :fecha")
    List<Object[]> obtenerReserva(Integer id, Date fecha);

    @Query("select new co.edu.uniquindio.unitravel.entidades.dto.ReservaDTO (r.cliente.nombre, r.fechaReserva, h.habitacion) from Reserva r join r.reservasHabitaciones h where h.habitacion.hotel.codigo = :id and r.fechaInicio < :fecha")
    List<ReservaDTO> obtenerReservaDto(Integer id, Date fecha);

    @Query("select v from Reserva r join r.reservasSillas rs join rs.silla s join s.vuelo v where r.fechaInicio <= :fechaMin and r.fechaFin >= :fechaMax")
    List<Vuelo> obtenerVuelosEntreFechas(Date fechaMin, Date fechaMax);

    //Punto uno taller
    @Query("select count(r) from Reserva r join r.reservasHabitaciones h where h.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio > current_date ")
    int obtenerNumeroDeReserva(Integer codigoHotel);

    //Punto Seis taller
    //@Query("select r.codigo, (select sum (rh.precio) from ReservaHabitacion rh where rh.reserva = r group by  r), (select sum (rs.precio) from ReservaSilla rs where rs.reserva) from")           Reserva  r")
    @Query("select r.codigo ,r.cliente.nombre, r.precioTotal from Reserva r where r.cliente.cedula  = :codigoUsuario")
    List<Object[]> obtenerTotalPorReserva(String codigoUsuario);

    //Punto ocho taller
    @Query("select  r, h, s from Reserva r join r.reservasHabitaciones h left join r.reservasSillas s where r.cliente.cedula = :codigo")
    List<Object[]> obtenerDetalleDeCadaReserva(String codigo);
}
