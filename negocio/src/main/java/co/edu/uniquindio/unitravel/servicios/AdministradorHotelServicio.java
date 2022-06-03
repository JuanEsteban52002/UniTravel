package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;

import java.util.ArrayList;
import java.util.List;

public interface AdministradorHotelServicio {

    AdministradorHotel validarLogin(String email, String password) throws Exception;

    Hotel crearHotel(Hotel hotel) throws Exception;

    void eliminarHotel(Integer codigoHotel) throws Exception;

    Hotel modificarHotel(Hotel hotel) throws Exception;

    List<Hotel> listarHoteles(String codigoAdmin);

    Habitacion crearHabitacion(Habitacion habitacion);

    void eliminarHabitacion(Integer numero) throws Exception;

    Habitacion modificarHabitacion(Habitacion habitacion) throws Exception;

    Habitacion obtenerHabitacion(Integer codigoHabitacion, Integer codigoHotel) throws Exception;

    List<Habitacion> listarHabitacionesHotel(String codigoHotel);

    Ciudad obtenerCiudad(Integer codigo)throws Exception;

    AdministradorHotel obtenerAdministradorHotel(String codigo) throws Exception;

    List<Ciudad> listarCiudades();

    Cama obtenerCama(Integer codigo) throws Exception;

}
