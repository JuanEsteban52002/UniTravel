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
            administradorServicio.crearCiudad(new Ciudad("Armenia", "https://parlamentoandino.org/images/P-Fundacin-de-Armenia.jpg%22"));
            administradorServicio.crearCiudad(new Ciudad("Bogotá", "https://upload.wikimedia.org/wikipedia/commons/2/24/Bogot%C3%A1_Colpatria_Night.jpg%22"));
            administradorServicio.crearCiudad(new Ciudad("Santa Marta", "https://cloudfront-us-east-1.images.arcpublishing.com/semana/W2USLWLWJ5FF3IJKDEHFYZSC5I.jpg"));
            administradorServicio.crearCiudad(new Ciudad("Pereira", "https://cdn.colombia.com/sdi/2022/01/13/turismo-pereira-top-25-987237.jpg%22"));
            administradorServicio.crearCiudad(new Ciudad("Cartagena", "https://cdn.colombia.com/images/v2/turismo/sitios-turisticos/cartagena/ciudad-cartagena-800.jpg%22"));
            administradorServicio.crearCiudad(new Ciudad("Barrancabermeja", "https://www.terminaldetransporte.gov.co/sites/default/files/2021-06/barrancabermeja.jpg%22"));
            administradorServicio.crearCiudad(new Ciudad("Manizales", "https://i0.wp.com/www.bcnoticias.com.co/wp-content/uploads/2019/05/UJFRDKZTCK_20190520172114.jpeg?resize=600%2C399%22"));
        }
    }
}
