package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional

public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private EmailServicio emailServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest() {
        Cliente c = new Cliente("1007914", "Jorge Antonio", "jorgea.511@gmail.com", "jorgeingeniero511");
        c.setTelefonos(new ArrayList<>());

        List<Telefono> telefonos = new ArrayList();

        Telefono telefono1 = new Telefono("3104178475", "Laboral");
        Telefono telefono2 = new Telefono("3174859635", "Mamá");
        Telefono telefono3 = new Telefono("3114785142", "Personal");

        telefonos.add(telefono1);
        telefonos.add(telefono2);
        telefonos.add(telefono3);

        c.setTelefonos(telefonos);

        try {
            Cliente cGuardado = clienteServicio.registrarCliente(c);
            Assertions.assertNotNull(cGuardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarClienteTest()  {
        try{
            Cliente c = new Cliente("1234", "Carlos", "carlos@gmail.com", "carlos");
            clienteServicio.actualizarCliente(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest() {
        try {
            clienteServicio.eliminarCliente("1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientesTest(){
        List<Cliente> clientes = clienteServicio.listarClientes();
        Assertions.assertEquals(4, clientes.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesCiudadTest(){

        try {
            List<Hotel> hoteles = clienteServicio.buscarHotelesCiudad("Bogota");
            hoteles.forEach(System.out::println);
            Assertions.assertEquals(2, hoteles.size());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void hacerReservaTest() throws Exception {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaReserva = formato.parse("2022-05-12");
        Date fechaInicio = formato.parse("2022-05-13");
        Date fechaFin = formato.parse("2022-05-16");

        Reserva reserva = new Reserva("3", fechaReserva, fechaInicio, fechaFin, Alimentacion.DESAYUNO_COMIDA, 1200000, EstadoReserva.PENDIENTE, 4);

        try {

            Reserva reservaGuardada = clienteServicio.hacerReserva(reserva);
            System.out.println(reservaGuardada);
            Assertions.assertNotNull(reservaGuardada);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void modificarReservaTest() throws Exception {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaReserva = formato.parse("2022-05-13");
        Date fechaInicio = formato.parse("2022-05-13");
        Date fechaFin = formato.parse("2022-05-16");

        Reserva reserva = new Reserva("3", fechaReserva, fechaInicio, fechaFin, Alimentacion.SIN_PLAN, 1200000, EstadoReserva.PENDIENTE, 4);

        try {

            clienteServicio.modificarReserva(reserva);
            System.out.println(reserva);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservasClienteTest(){

        List<Reserva> reservas = clienteServicio.listarReservasCliente("juan@gmail.com");
        reservas.forEach(System.out::println);
        Assertions.assertEquals(1, reservas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarReservaTest(){

        try {
            clienteServicio.eliminarReserva("2");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentarioTest(){

        Comentario comentario = new Comentario("5", "El hotel es muy bonito y grande", 4);

        try {

            Comentario comentarioGuardado = clienteServicio.crearComentario(comentario);
            System.out.println(comentarioGuardado);
            Assertions.assertNotNull(comentarioGuardado);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarComentarioTest(){

        try {

            clienteServicio.eliminarComentario("4");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void recuperarPasswordTest(){

        try {

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void enviarCorreo() {
        boolean estado = emailServicio.enviarMail("Confirmacion de compra", "Hola, Unitravel te informa que acabas de realizar una compra exitosamente", "juane.grandar@uqvirtual.edu.co");
        Assertions.assertTrue(estado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void validarLoginTest(){
        try{
            Cliente clienteBuscado = clienteServicio.validarLogin("juan@gmail.com", "5555");

            Assertions.assertNotNull(clienteBuscado);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
