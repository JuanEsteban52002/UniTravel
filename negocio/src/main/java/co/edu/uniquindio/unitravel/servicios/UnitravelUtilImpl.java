package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitravelUtilImpl implements UnitravelUtilServicio{

    private CaracteristicaRepo caracteristicaRepo;
    private CiudadRepo ciudadRepo;
    private CamaRepo camaRepo;

    private AdministradorRepo administradorRepo;

    private AdministradorHotelRepo administradorHotelRepo;

    private ClienteRepo clienteRepo;
    private HotelRepo hotelRepo;

    public UnitravelUtilImpl(CaracteristicaRepo caracteristicaRepo,
                             CiudadRepo ciudadRepo,
                             CamaRepo camaRepo,
                             ClienteRepo clienteRepo,
                             AdministradorHotelRepo administradorHotelRepo,
                             AdministradorRepo administradorRepo,
                             HotelRepo hotelRepo){
        this.ciudadRepo = ciudadRepo;
        this.caracteristicaRepo = caracteristicaRepo;
        this.camaRepo = camaRepo;
        this.hotelRepo = hotelRepo;
        this.clienteRepo = clienteRepo;
        this.administradorHotelRepo = administradorHotelRepo;
        this.administradorRepo = administradorRepo;
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
    public Persona validarLogin(String correo, String password) throws Exception {

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        Persona cliente = clienteRepo.findByEmail(correo).orElse(null);

        if (cliente == null) {
            cliente = administradorHotelRepo.findByEmail(correo).orElse(null);
        }else{
            if(!passwordEncryptor.checkPassword(password, cliente.getPassword())){
                throw new Exception("Contraseña incorrecta");
            }else{
                return cliente;
            }
        }

        if (cliente == null) {
            cliente = administradorRepo.findByEmail(correo).orElse(null);
        }else{
            if(!passwordEncryptor.checkPassword(password, cliente.getPassword())){
                throw new Exception("Contraseña incorrecta");
            }else{
                return cliente;
            }
        }

        if (cliente == null) {
            throw new Exception("El correo o la contraseña son incorrectos");
        }else{
            if(!passwordEncryptor.checkPassword(password, cliente.getPassword())){
                throw new Exception("Contraseña incorrecta");
            }else{
                return cliente;
            }
        }
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
