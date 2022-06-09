package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio {

    private AdministradorRepo administradorRepo;
    private CiudadRepo ciudadRepo;
    private VueloRepo vueloRepo;
    private AdministradorHotelRepo administradorHotelRepo;

    private CaracteristicaRepo caracteristicaRepo;

    public AdministradorServicioImpl(AdministradorRepo administradorRepo,
                                     CiudadRepo ciudadRepo,
                                     VueloRepo vueloRepo,
                                     AdministradorHotelRepo administradorHotelRepo,
                                     CaracteristicaRepo caracteristicaRepo) {
        this.administradorRepo = administradorRepo;
        this.ciudadRepo = ciudadRepo;
        this.vueloRepo = vueloRepo;
        this.administradorHotelRepo = administradorHotelRepo;
        this.caracteristicaRepo = caracteristicaRepo;
    }


    @Override
    public Administrador validarLogin(String email, String password) throws Exception {

        if(email.isEmpty() || password.isEmpty()){
            throw  new Exception("Por favor llenar todos los campos de texto");
        }

        Optional<Administrador> administrador = administradorRepo.findByEmail(email);

        if(administrador.equals(null)) {
            throw new Exception("Los datos de autenticacion son incorrectos");
        }

        return administrador.get();
    }

    @Override
    public AdministradorHotel registrarAdminHotel(AdministradorHotel administradorHotel) throws Exception {

        if(administradorHotel == null){
            throw  new Exception("Por favor llene todos los campos, para poder registrar");
        }

        AdministradorHotel adminHotel = obtenerAdministradorHotel(administradorHotel.getCedula());

        if(adminHotel == null) {
            throw new Exception("El administrador ya existe");
        }

        return administradorHotelRepo.save(administradorHotel);
    }

    public AdministradorHotel obtenerAdministradorHotel(String cedulaAdminHotel) throws Exception{

        AdministradorHotel administradorHotel = administradorHotelRepo.findById(cedulaAdminHotel).orElse(null);

        return administradorHotel;
    }

    @Override
    public void eliminarAdminHotel(String cedulaAdminHotel) throws Exception {

        AdministradorHotel adminHotel = obtenerAdministradorHotel(cedulaAdminHotel);

        if(adminHotel == null) {
            throw new Exception("El administrador hotel no existe");
        }

        administradorHotelRepo.delete(adminHotel);
    }

    @Override
    public AdministradorHotel modificarAdminHotel(AdministradorHotel administradorHotel) throws Exception {
        return administradorHotelRepo.save(administradorHotel);
    }

    @Override
    public List<AdministradorHotel> listarAdminHotel() {
        return administradorHotelRepo.findAll();
    }

    @Override
    public Vuelo crearVuelo(Vuelo vuelo) throws Exception {

        Vuelo vueloBuscado = obtenerVuelo(vuelo.getCodigo());

        if(vueloBuscado != null) {
            throw new Exception("El vuelo ya existe");
        }

        return vueloRepo.save(vuelo);
    }

    public Vuelo obtenerVuelo(String codigoVuelo){
        return vueloRepo.findById(codigoVuelo).orElse(null);
    }

    @Override
    public void eliminarVuelo(String codigoVuelo) throws Exception {
        Vuelo vuelo = obtenerVuelo(codigoVuelo);

        if(vuelo == null) {
            throw new Exception("El vuelo no existe");
        }

        vueloRepo.delete(vuelo);
    }

    @Override
    public Vuelo modificarVuelo(Vuelo vuelo) throws Exception {
        return vueloRepo.save(vuelo);
    }

    @Override
    public List<Vuelo> listarVuelos() {

        return vueloRepo.findAll();
    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) throws Exception {

        Ciudad ciudadBuscada = obtenerCiudad(ciudad.getCodigo());

        if(ciudadBuscada != null) {
            throw new Exception("La ciudad ya existe");
        }
        return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception {

        if(ciudad == null){
            throw new Exception("Por favor llene todos los campos, para poder registrar");
        }

        if(obtenerCiudad(ciudad.getCodigo()) == null) {
            throw new Exception("La ciudad no existe");
        }

        return ciudadRepo.save(ciudad);
    }

    public Ciudad obtenerCiudad(Integer codigoCiudad) throws Exception {
        return ciudadRepo.findById(codigoCiudad).orElse(null);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public void eliminarCiudad(Integer codigoCiudad) throws Exception {
        Ciudad ciudad = obtenerCiudad(codigoCiudad);

        if(ciudad == null) {
            throw new Exception("La ciudad no existe");
        }
        ciudadRepo.delete(ciudad);
    }

    @Override
    public Caracteristica crearCaracteristica(Caracteristica caracteristica) throws Exception {
        return caracteristicaRepo.save(caracteristica);
    }
}
