package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.CamaRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorHotelServicioImpl implements AdministradorHotelServicio {

    private AdministradorHotelRepo adminHotelRepo;
    private HotelRepo hotelRepo;
    private CiudadRepo ciudadRepo;
    private CamaRepo camaRepo;

    public AdministradorHotelServicioImpl(AdministradorHotelRepo adminHotelRepo
            ,HotelRepo hotelRepo, CiudadRepo ciudadRepo, CamaRepo camaRepo) {
        this.adminHotelRepo = adminHotelRepo;
        this.hotelRepo = hotelRepo;
        this.ciudadRepo = ciudadRepo;
        this.camaRepo = camaRepo;
    }

    @Override
    public AdministradorHotel validarLogin(String email, String password) throws Exception {

        if(email.isEmpty() || password.isEmpty()){
            throw new Exception("Por favor rellenar todo los campos de texto");
        }

        Optional<AdministradorHotel> adminHotel = adminHotelRepo.findByEmail(email);

        if(adminHotel.equals(null)){
            throw new Exception("Los datos de autenticacion son incorrectos");
        }

        return adminHotel.get();
    }

    @Override
    public Hotel crearHotel(Hotel hotel) throws Exception {

        if(hotel == null){
            throw  new Exception("El hotel a crear, esta incompleto");
        }

        Hotel hotelBuscado = obtenerHotel(hotel.getCodigo());
        if(hotelBuscado != null){
            throw new Exception("El hotel ya existe");
        }
        return hotelRepo.save(hotel);
    }

    @Override
    public void eliminarHotel(Integer codigoHotel) throws Exception {

        if(codigoHotel ==  null){
            throw new Exception("No envio niguno codigo");
        }
        Hotel hotel = obtenerHotel(codigoHotel);

        if(hotel == null){
            throw new Exception("El hotel no existe");
        }
        hotelRepo.delete(hotel);
    }

    @Override
    public Hotel modificarHotel(Hotel hotel) throws Exception {
        if(hotel == null){
            throw new Exception("Por favor envie un hotel a modificar");
        }
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> listarHoteles(String codigoAdmin) {
        return adminHotelRepo.obtenerHotelesAdmin(codigoAdmin);
    }

    public Hotel obtenerHotel(Integer codigoHotel) throws Exception  {
        if(codigoHotel == null){
            throw new Exception("Por favor envie un codigo");
        }
        return hotelRepo.findById(codigoHotel).orElse(null);
    }

    @Override
    public Habitacion crearHabitacion(Habitacion habitacion) {

        return null;
    }

    @Override
    public void eliminarHabitacion(Integer numero) throws Exception {

    }

    @Override
    public Habitacion modificarHabitacion(Habitacion habitacion) throws Exception {
        return null;
    }

    @Override
    public Habitacion obtenerHabitacion(Integer codigoHabitacion, Integer codigoHotel) throws Exception {
        return adminHotelRepo.obtenerHabitacion(codigoHabitacion, codigoHotel);
    }

    @Override
    public List<Habitacion> listarHabitacionesHotel(String codigoHotel) {

        return null;
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        return ciudadRepo.findById(codigo).orElse(null);
    }

    @Override
    public AdministradorHotel obtenerAdministradorHotel(String codigo) throws Exception {
        return adminHotelRepo.findById(codigo).orElse(null);
    }

    @Override
    public List<Ciudad> listarCiudades() {

        return ciudadRepo.findAll();
    }

    @Override
    public Cama obtenerCama(Integer codigo) throws Exception {
        return camaRepo.findById(codigo).orElse(null);
    }


}
