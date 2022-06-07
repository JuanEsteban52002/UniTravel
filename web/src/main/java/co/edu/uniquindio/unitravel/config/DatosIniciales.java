package co.edu.uniquindio.unitravel.config;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelUtilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements CommandLineRunner {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private UnitravelUtilServicio unitravelUtilServicio;

    @Override
    public void run(String... args) throws Exception {

        if (unitravelUtilServicio.listarCiudades().isEmpty()) {

            administradorServicio.crearCiudad(new Ciudad("Armenia"));
            administradorServicio.crearCiudad(new Ciudad("Pereira"));
            administradorServicio.crearCiudad(new Ciudad("Bogota"));
            administradorServicio.crearCiudad(new Ciudad("Barranquilla"));
            administradorServicio.crearCiudad(new Ciudad("Cali"));
        }
    }
}
