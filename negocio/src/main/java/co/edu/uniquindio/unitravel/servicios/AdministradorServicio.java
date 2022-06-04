package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;

import java.util.List;

public interface AdministradorServicio {

    Administrador validarLogin(String email, String password) throws Exception;

    //Admin Hotel

    AdministradorHotel registrarAdminHotel(AdministradorHotel administradorHotel) throws Exception;

    void eliminarAdminHotel(String cedulaAdminHotel) throws Exception;

    AdministradorHotel modificarAdminHotel(AdministradorHotel administradorHotel) throws Exception;

    List<AdministradorHotel> listarAdminHotel() ;

    //Vuelos

    Vuelo crearVuelo(Vuelo vuelo) throws Exception;

    void eliminarVuelo(String codigoVuelo) throws Exception;

    Vuelo modificarVuelo(Vuelo vuelo) throws Exception;

    List<Vuelo> listarVuelos();

    //Destions

    Ciudad crearCiudad(Ciudad ciudad) throws Exception;

    Ciudad actualizarCiudad(Ciudad ciudad) throws Exception;

    List<Ciudad> listarCiudades();

    void eliminarCiudad(Integer codigoCiudad) throws Exception;
}
