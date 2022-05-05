package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServicioImpl implements AdministradorServicio {



    @Override
    public Administrador validarLogin(String email, String password) throws Exception {
        return null;
    }

    @Override
    public AdministradorHotel registrarAdminHotel(AdministradorHotel administradorHotel) throws Exception {
        return null;
    }

    @Override
    public Vuelo crearVuelo(Vuelo vuelo) throws Exception {
        return null;
    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) throws Exception {
        return null;
    }
}
