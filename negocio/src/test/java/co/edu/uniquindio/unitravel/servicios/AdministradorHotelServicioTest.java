package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@SpringBootTest
public class AdministradorHotelServicioTest {

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;


        @Test
    @Sql("classpath:dataset.sql")
    public void validarLoginTest() throws Exception{

        try {
            AdministradorHotel adminBuscado = administradorHotelServicio.validarLogin("admin1@gmail.com", "admin1");

            Assertions.assertNotNull(adminBuscado);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test
    @Sql("classpath:dataset.sql")
    public void crearHotelTest() throws Exception{

        Hotel hotel = new Hotel(4, "Hotel los Angeles", "carrera 45 calle 21", "751586263", 4);

        try{

            Hotel hotelGuardado = administradorHotelServicio.crearHotel(hotel);
            System.out.println(hotelGuardado);
            Assertions.assertNotNull(hotelGuardado);

        }catch (Exception e){
            e.printStackTrace();
        }

    }



    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHotelTest() throws Exception{

        try{
            administradorHotelServicio.eliminarHotel(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void modificarHotelTest() throws Exception {
        try{
            Hotel hotel = new Hotel(4, "Hotel los Angeles", "carrera 49 - calle 21", "751586263", 5);
            administradorHotelServicio.modificarHotel(hotel);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesTest()  {

        List<Hotel> hoteles = administradorHotelServicio.listarHoteles("5555");
        hoteles.forEach(System.out::println);
        Assertions.assertEquals(2, hoteles.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotelTest() throws Exception{

        try{
            Hotel hotel = administradorHotelServicio.obtenerHotel(1);
            System.out.println(hotel);
            Assertions.assertEquals(1, hotel.getCodigo());

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
