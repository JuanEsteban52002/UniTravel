package co.edu.uniquindio.unitravel.config;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelUtilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
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
            try{
                administradorServicio.crearCiudad(new Ciudad("Medellin", "https://traveler.marriott.com/es/wp-content/uploads/sites/2/2021/01/GI-529527806-Medellin-1920x1080.png"));
                administradorServicio.crearCiudad(new Ciudad("Armenia", "https://www.desktodirtbag.com/wp-content/uploads/2017/05/armenia-colombia-11.jpg"));
                administradorServicio.crearCiudad(new Ciudad("Cartagena", "https://i2.wp.com/ail.ens.org.co/wp-content/uploads/sites/3/2020/03/Cartagena.jpg?fit=1540%2C1024&ssl=1"));
                administradorServicio.crearCiudad(new Ciudad("Santa Marta", "https://traveler.marriott.com/es/wp-content/uploads/sites/2/2021/06/GI-1078056138-Santa-Marta.jpg"));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
