package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorHotelServicioImpl implements AdministradorHotelServicio {

    private AdministradorHotelRepo adminHotelRepo;
    private HotelRepo hotelRepo;

    public AdministradorHotelServicioImpl(AdministradorHotelRepo adminHotelRepo, HotelRepo hotelRepo){
        this.adminHotelRepo = adminHotelRepo;
        this.hotelRepo = hotelRepo;
    }

    @Override
    public AdministradorHotel validarLogin(String email, String password) throws Exception {

        Optional<AdministradorHotel> adminHotel = adminHotelRepo.findByEmailAndPassword(email, password);

        if(adminHotel.isEmpty()){
            throw new Exception("Los datos de autenticacion son incorrectos");
        }

        return adminHotel.get();
    }

    @Override
    public Hotel crearHotel(Hotel hotel) throws Exception {

        Hotel hotelBuscado = obtenerHotel(hotel.getCodigo());
        if(hotelBuscado != null){
            throw new Exception("El hotel ya existe");
        }
        return hotelRepo.save(hotel);
    }

    @Override
    public void eliminarHotel(Integer codigoHotel) throws Exception {
        Hotel hotel = obtenerHotel(codigoHotel);

        if(hotel == null){
            throw new Exception("El hotel no existe");
        }
        hotelRepo.delete(hotel);
    }

    @Override
    public Hotel modificarHotel(Hotel hotel) throws Exception {
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> listarHoteles(String codigoAdmin) {
        return adminHotelRepo.obtenerHotelesAdmin(codigoAdmin);
    }

    @Override
    public Hotel obtenerHotel(Integer codigoHotel)  {
        return hotelRepo.findById(codigoHotel).orElse(null);
    }
}
