package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.TipoCaracteritica;
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
        return caracteristicaRepo.findById(Integer.toString(codigo)).orElseThrow(() -> new Exception("EL codigo no existe"));
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHotel() {
        Caracteristica ca = new Caracteristica();
        ca.setTipoCaracteritica(TipoCaracteritica.HOTEL);
        System.out.println(ca.getTipoCaracteritica());
        ca.setTipoCaracteritica(TipoCaracteritica.HABITACION);
        System.out.println(ca.getTipoCaracteritica());
        for(Caracteristica c : caracteristicaRepo.obtenerCaracteristicasSegunTipo(TipoCaracteritica.HOTEL)){
            System.out.println(c.getNombre());
        }
        return caracteristicaRepo.obtenerCaracteristicasSegunTipo(TipoCaracteritica.HOTEL);
    }

    @Override
    public List<Caracteristica> todasLasCaracteristica() {
        return caracteristicaRepo.findAll();
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHabitacion() {
        return caracteristicaRepo.obtenerCaracteristicasSegunTipo(TipoCaracteritica.HABITACION);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

}
