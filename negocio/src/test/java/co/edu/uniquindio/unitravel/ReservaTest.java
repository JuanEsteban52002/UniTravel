package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.entidades.dto.ReservaDTO;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
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
public class ReservaTest {

    @Autowired
    private ReservaRepo reservaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Date fechaReserva = new Date(22,5,13);
        Date fechaInicio = new Date(22,5,13);
        Date fechaFin = new Date(22,5,16);


        Reserva reserva = new Reserva("R4", fechaReserva, fechaInicio, fechaFin, Alimentacion.DESAYUNO_COMIDA, 1200000, EstadoReserva.PENDIENTE, 4);

        Reserva reservaGuardada = reservaRepo.save(reserva);

        Assertions.assertNotNull(reservaGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Reserva reserva = reservaRepo.findById("1").orElse(null);
        reserva.setEstado(EstadoReserva.EN_PROCESO);
        reservaRepo.save(reserva);
        reservaRepo.findById("1").orElse(null);
        Assertions.assertEquals(EstadoReserva.EN_PROCESO, reserva.getEstado());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        reservaRepo.deleteById("1");
        Reserva reserva = reservaRepo.findById("1").orElse(null);
        Assertions.assertNull(reserva);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Reserva> reservas = reservaRepo.findAll();
        reservas.forEach (System.out:: println);
    }

    /*
                Consultas
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHabitacionesDisponiblesFechas() throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaMin = formato.parse("2022-05-15");
        Date fechaMax = formato.parse("2022-05-17");


        List<Habitacion> habitaciones = reservaRepo.obtenerHabitacionesDisponiblesFechas( fechaMin, fechaMax);
        System.out.println(habitaciones);
        Assertions.assertEquals(1, habitaciones.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void devolverReservaIntervaloFecha() throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaMin = formato.parse("2022-05-12");
        Date fechaMax = formato.parse("2022-05-15");


        List<Reserva> reservas = reservaRepo.devolverReservaIntervaloFecha( fechaMin, fechaMax);
        System.out.println(reservas);
        Assertions.assertEquals(1, reservas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerReserva() throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaBuscar = formato.parse("2022-05-13");

        List<Object[]> reservas = reservaRepo.obtenerReserva(1, fechaBuscar);
        reservas.forEach(r -> System.out.println(r[0] + "-" + r[1]));
        Assertions.assertNotNull(reservas.get(0)[0]);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerReservaDto() throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaBuscar = formato.parse("2022-05-13");


        List<ReservaDTO> reservas = reservaRepo.obtenerReservaDto(1, fechaBuscar);
        reservas.forEach(System.out::println);
        Assertions.assertEquals(1, reservas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerVuelosEntreFechas() throws ParseException {


        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaMin = formato.parse("2022-05-13");
        Date fechaMax = formato.parse("2022-05-15");

        List<Vuelo> vuelos = reservaRepo.obtenerVuelosEntreFechas( fechaMin, fechaMax);
        System.out.println(vuelos);
        Assertions.assertEquals(1, vuelos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerNumeroDeReserva() {

        int reserva = reservaRepo.obtenerNumeroDeReserva( 1);
        System.out.println(reserva);
        Assertions.assertEquals(1, reserva);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerTotalPorReserva() {

        List<Object[]> reserva = reservaRepo.obtenerTotalPorReserva( "1234");
        reserva.forEach(r -> System.out.println(r[0] + "-" + r[1] + "-" + r[2]));
        Assertions.assertNotNull(reserva.get(0)[0]);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerDetalleDeCadaReserva() {

        List<Object[]> reserva = reservaRepo.obtenerDetalleDeCadaReserva( "1234");
        reserva.forEach(r -> System.out.println(r[0] + "-" + r[1] + "-" + r[2]));
        Assertions.assertNotNull(reserva.get(0)[0]);
    }


}
