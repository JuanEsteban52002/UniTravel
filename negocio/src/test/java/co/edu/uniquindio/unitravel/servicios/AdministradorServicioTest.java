package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@SpringBootTest
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void validarLoginTest() throws Exception{

        try {

            Administrador adminBuscado = administradorServicio.validarLogin("adminUnitravel1@gmail.com", "adminUni1");

            Assertions.assertNotNull(adminBuscado);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarAdminHotel() throws Exception{

        AdministradorHotel administradorHotel = new AdministradorHotel("697489", "Manuel Antonio", "manuelantonio@gmail.com", "SoyAdmin123");

        try {
            administradorServicio.registrarAdminHotel(administradorHotel);
            System.out.println(administradorHotel);
            Assertions.assertNotNull(administradorHotel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarAdminHotel() throws Exception{

        try {
            administradorServicio.eliminarAdminHotel("5555");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void modificarAdminHotel() throws Exception{

        try {

            AdministradorHotel administradorHotel = new AdministradorHotel("5555", "Manuel Antonio",  "manuelantonio@gmail.com", "SoyAdminHotel777");
            administradorServicio.modificarAdminHotel(administradorHotel);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdminHotel()  {

        List<AdministradorHotel> administradoresHotel = administradorServicio.listarAdminHotel();
        administradoresHotel.forEach(System.out::println);
        Assertions.assertEquals(2, administradoresHotel.size());

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void crearVuelo() throws Exception{

        Vuelo vuelo = new Vuelo("4", Estado.DISPONIBLE, "Avianca");

        try {
            administradorServicio.crearVuelo(vuelo);
            System.out.println(vuelo);
            Assertions.assertNotNull(vuelo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarVuelo() throws Exception{

        try {
            administradorServicio.eliminarVuelo("2");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void modificarVuelo() throws Exception{

        try {
            Vuelo vuelo = new Vuelo("4", Estado.NO_DISPONIBLE, "Avianca");
            administradorServicio.modificarVuelo(vuelo);
            System.out.println(vuelo);
            Assertions.assertEquals(Estado.NO_DISPONIBLE, vuelo.getEstado());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarVuelos(){

        List<Vuelo> vuelos = administradorServicio.listarVuelos();
        vuelos.forEach(System.out::println);
        Assertions.assertEquals(3, vuelos.size());

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void crearCiudad() throws Exception{

        Ciudad ciudad = new Ciudad(7, "Armenia");
        try {
            Ciudad ciudadGuardada = administradorServicio.crearCiudad(ciudad);
            System.out.println(ciudadGuardada);
            Assertions.assertNotNull(ciudadGuardada);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCiudad() throws Exception{


        try {
            Ciudad ciudad = new Ciudad(7, "Popayan");
            System.out.println(ciudad);
            administradorServicio.actualizarCiudad(ciudad);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudades(){

        List<Ciudad> ciudades = administradorServicio.listarCiudades();
        ciudades.forEach(System.out::println);
        Assertions.assertEquals(6, ciudades.size());

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCiudad() throws Exception{

        try {
            administradorServicio.eliminarCiudad(4);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
