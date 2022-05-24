package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.CamaRepo;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitravelUtilImpl implements UnitravelUtilServicio{

    private CaracteristicaRepo caracteristicaRepo;
    private CiudadRepo ciudadRepo;
    private CamaRepo camaRepo;

    private HotelRepo hotelRepo;

    public UnitravelUtilImpl(CaracteristicaRepo caracteristicaRepo,
                             CiudadRepo ciudadRepo,
                             CamaRepo camaRepo,
                             HotelRepo hotelRepo){
        this.ciudadRepo = ciudadRepo;
        this.caracteristicaRepo = caracteristicaRepo;
        this.camaRepo = camaRepo;
    }

    @Override
    public Hotel obtenerHotel(Integer codigoHotel) throws Exception  {
        if(codigoHotel == null){
            throw new Exception("Por favor envie un codigo");
        }
        return hotelRepo.findById(codigoHotel).orElse(null);
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

    @Override
    public List<Cama> listarCamas() {
        return camaRepo.findAll();
    }

}
