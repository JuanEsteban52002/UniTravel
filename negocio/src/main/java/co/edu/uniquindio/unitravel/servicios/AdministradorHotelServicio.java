package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;

import java.util.ArrayList;
import java.util.List;

public interface AdministradorHotelServicio {

    AdministradorHotel validarLogin(String email, String password) throws Exception;

    Hotel crearHotel(Hotel hotel) throws Exception;

    void eliminarHotel(Integer codigoHotel) throws Exception;

    Hotel modificarHotel(Hotel hotel) throws Exception;

    List<Hotel> listarHoteles(String codigoAdmin);

    Hotel obtenerHotel(Integer codigoHotel) throws Exception;

    Ciudad obtenerCiudad(Integer codigo)throws Exception;

    AdministradorHotel obtenerAdministradorHotel(String codigo) throws Exception;

    List<Ciudad> listarCiudades();

}
