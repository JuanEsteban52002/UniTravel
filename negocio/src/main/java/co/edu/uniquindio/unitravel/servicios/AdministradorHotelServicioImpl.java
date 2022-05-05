package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorHotelServicioImpl implements AdministradorHotelServicio {

    private AdministradorHotelRepo adminHotelRepo;

    public AdministradorHotelServicioImpl(AdministradorHotelRepo adminHotelRepo){
        this.adminHotelRepo = adminHotelRepo;
    }

    @Override
    public AdministradorHotel validarLogin(String email, String password) throws Exception {
        return null;
    }

    @Override
    public Hotel crearHotel(Hotel hotel) {

        return null;
    }

    @Override
    public void eliminarHotel(Hotel hotel) {

    }

    @Override
    public Hotel modificarHotel(Hotel hotel) throws Exception {
        return null;
    }

    @Override
    public List<Hotel> listarHoteles(String codigoAdmin) {

        return adminHotelRepo.obtenerHotelesAdmin(codigoAdmin);
    }

    @Override
    public Hotel obtenerHotel(String codigoHotel) throws Exception {
        return null;
    }
}
