package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitravelUtilImpl implements UnitravelUtilServicio{

    private CaracteristicaRepo caracteristicaRepo;

    //----------------------------------------------------------//
    @Override
    public Caracteristica obtenerCaracteristica(Integer codigo) throws Exception {
        return caracteristicaRepo.findById(Integer.toString(codigo)).orElseThrow(() -> new Exception("EL codigo no existe"));
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHotel() {
        return caracteristicaRepo.findAllbyTipo(0);
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHabitacion() {
        return caracteristicaRepo.findAllbyTipo(1);
    }

}
