package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;

import java.util.List;

public interface UnitravelUtilServicio {

    Caracteristica obtenerCaracteristica(Integer codigo) throws Exception;

    List<Caracteristica> listarCaracteristicasHotel();

    List<Caracteristica> listarCaracteristicasHabitacion();


}
