package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;

public interface UnitravelUtilServicio {

    //LOGIN

    Persona validarLogin(String correo, String password) throws Exception;
    Hotel obtenerHotel(Integer codigoHotel) throws Exception;
    Caracteristica obtenerCaracteristica(Integer codigo) throws Exception;
    List<Caracteristica> listarCaracteristicas();
    List<Caracteristica> listarCaracteristicasHotel();
    List<Caracteristica> listarCaracteristicasHabitacion();
    List<Ciudad> listarCiudades();
    List<Cama> listarCamas();

}
