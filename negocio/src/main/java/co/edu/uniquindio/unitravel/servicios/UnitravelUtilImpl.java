package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitravelUtilImpl implements UnitravelUtilServicio{

    private CaracteristicaRepo caracteristicaRepo;
    private CiudadRepo ciudadRepo;

    public UnitravelUtilImpl(CaracteristicaRepo caracteristicaRepo, CiudadRepo ciudadRepo){
        this.ciudadRepo = ciudadRepo;
        this.caracteristicaRepo = caracteristicaRepo;
    }

    //----------------------------------------------------------//
    @Override
    public Caracteristica obtenerCaracteristica(Integer codigo) throws Exception {
        return caracteristicaRepo.findById(codigo).orElseThrow(() -> new Exception("EL codigo no existe"));
    }

    @Override
    public List<Caracteristica> listarCaracteristicas() {
        return caracteristicaRepo.findAll();
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHotel() {
        return caracteristicaRepo.findAllByTipo(0);
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHabitacion() {
        return caracteristicaRepo.findAllByTipo(1);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

}
