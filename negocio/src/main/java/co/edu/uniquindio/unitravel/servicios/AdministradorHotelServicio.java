package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;

import java.util.List;

public interface AdministradorHotelServicio {

    AdministradorHotel validarLogin(String email, String password) throws Exception;

    Hotel crearHotel(Hotel hotel);

    void eliminarHotel(Hotel hotel);

    Hotel modificarHotel(Hotel hotel) throws Exception;

    List<Hotel> listarHoteles(String codigoAdmin);

    Hotel obtenerHotel(String codigoHotel) throws Exception;



}
