package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class HotelTest {

    @Autowired
    private HotelRepo hotelRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void buscar() {
        Hotel hotel = hotelRepo.findById(1).orElse(null);
        System.out.println(hotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesCincoEstrellas() {
        List<Hotel> hoteles = hotelRepo.findAllByNumEstrellas(5);
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Hotel hotel = new Hotel(4, "Hotel 4", "Carrea 43, calle 12", "316185651", 5);
        Hotel hotelGuardado = hotelRepo.save(hotel);

        Assertions.assertNotNull(hotelGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Hotel hotel = hotelRepo.findById(1).orElse(null);
        hotel.setDireccion("Calle 123");
        hotelRepo.save(hotel);
        hotelRepo.findById(1).orElse(null);
        Assertions.assertEquals("Calle 123", hotel.getDireccion());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        hotelRepo.deleteById(1);
        Hotel hotel = hotelRepo.findById(1).orElse(null);
        Assertions.assertNull(hotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Hotel> lista = hotelRepo.findAll();
        System.out.println(lista);
    }

    /*
                Consultas
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void determinarNumeroReservasHotelFecha() throws ParseException {


        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaBuscar = formato.parse("2022-05-13");


        Integer numeroReservas = hotelRepo.determinarNumeroReservasHotelFecha(1, fechaBuscar);
        System.out.println(numeroReservas);
        Assertions.assertEquals(1, numeroReservas);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHoteles() {

        List<Hotel> reservas = hotelRepo.obtenerHoteles(5);
        System.out.println(reservas);
        Assertions.assertEquals(1, reservas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findAllByNumEstrellas() {

        List<Hotel> reservas = hotelRepo.findAllByNumEstrellas(4);
        System.out.println(reservas);
        Assertions.assertEquals(2, reservas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComentariosHotel() {

        List<Comentario> comentarios = hotelRepo.obtenerComentariosHotel(1);
        comentarios.forEach(System.out::println);
        Assertions.assertEquals(2, comentarios.size());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesEntrePrecios() {

        List<Hotel> hoteles = hotelRepo.buscarHotelesEntrePrecios(30000.0, 60000.0);
        hoteles.forEach(System.out::println);
        Assertions.assertEquals(2, hoteles.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerNombreCiudad() {

        String ciudad = hotelRepo.obtenerNombreCiudad(1);
        System.out.println(ciudad);
        Assertions.assertEquals("Bogota",ciudad );
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotelesPorCiudad() {

        List<Hotel> hoteles = hotelRepo.obtenerHotelesCiudad("Bogota");
        hoteles.forEach(System.out::println);
        Assertions.assertEquals(2, hoteles.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void contarHotelesPorCiudad() {

        List<Object[]> hoteles = hotelRepo.contarHotelesPorCiudad();
        hoteles.forEach(h -> System.out.println( "Ciudad: " + h[0] + " - " + "Cantidad Hoteles: " + h[1]));
        Assertions.assertNotNull(hoteles.get(0)[0]);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotelSinComentarios() {

        List<Hotel> hoteles = hotelRepo.obtenerHotelSinComentarios();
        hoteles.forEach(System.out::println);
        Assertions.assertEquals(0, hoteles.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotelesNombre() {

        List<Hotel> hoteles = hotelRepo.obtenerHotelesNombre("hotel");
        hoteles.forEach(System.out::println);
        Assertions.assertEquals(3, hoteles.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCalificacionPromedioPorHotel() {

        List<Object[]> hoteles = hotelRepo.obtenerCalificacionPromedioPorHotel();
        hoteles.forEach(h -> System.out.println( "Hotel: " + h[0] + " - " + "Calificacion: " + h[1]));
        Assertions.assertNotNull(hoteles.get(0)[0]);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesCiudad() {

        List<Hotel> hoteles = hotelRepo.obtenerHotelesCiudad("Bogota");
        hoteles.forEach(System.out::println);
        Assertions.assertEquals(2, hoteles.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesPrecio() {

        List<Hotel> hoteles = hotelRepo.buscarHotelesEntrePrecios(30000, 60000);
        hoteles.forEach(System.out::println);
        Assertions.assertNotNull(hoteles.get(0));
    }



}
