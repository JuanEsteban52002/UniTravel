package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar(){
        Cliente cliente = new Cliente("1004916310", "Juan", "juan@gmail.com", "1234");
        Cliente clienteGuardado = clienteRepo.save(cliente);

        Assertions.assertNotNull(clienteGuardado);
    }

    @Test
    public void eliminar() {
        Cliente cliente = new Cliente("1004916310", "Juan", "juan@gmail.com", "1234");
        Cliente clienteGuardado = clienteRepo.save(cliente);

        clienteRepo.delete(clienteGuardado);

        Cliente clienteBuscado = clienteRepo.findById("1004916310").orElse(null);

        Assertions.assertNull(clienteBuscado);
    }

    @Test
    public void actualizar(){
        Cliente cliente = new Cliente("1004916310", "Juan", "juan@gmail.com", "1234");

        Cliente clienteGuardado = clienteRepo.save(cliente);
        clienteGuardado.setPassword("Juan123");

        clienteRepo.save(clienteGuardado);

        Cliente clienteBuscado = clienteRepo.findById("1004916310").orElse(null);
        Assertions.assertEquals("Juan123", clienteBuscado.getPassword());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Cliente> clientes = clienteRepo.findAll();
        clientes.forEach (System.out:: println);
    }

    /*
                        Consultas
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPrecioReserva() {

        double  precioReserva = clienteRepo.obtenerPrecioReserva("1234", "1");
        System.out.println(precioReserva);
        Assertions.assertEquals(100000, precioReserva);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerTotalPrecioReservas() {

        double  precioTotalReserva = clienteRepo.obtenerTotalPrecioReservas("1234");
        System.out.println(precioTotalReserva);
        Assertions.assertEquals(100000, precioTotalReserva);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void devolverDetalleReservaSegunCliente() {

        List<Object[]> detalleReserva= clienteRepo.devolverDetalleReservaSegunCliente("1234");
        detalleReserva.forEach (d -> System.out.println("Codigo Reserva: " + d[0] + " - " + "Fecha Inicio: "
                + d[1] + " - " + "Fecha Fin: " + d[2] + " - " + "Precio Total: " + d[3]));

        Assertions.assertEquals("1", detalleReserva.get(0)[0]);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerReservasClientes() {

        List<Object[]> listaClientes = clienteRepo.obtenerReservasClientes();
        listaClientes.forEach (l -> System.out.println("Cliente: " + l[0] + " - " + "Reserva: " + l[1]));
        Assertions.assertNotNull(listaClientes.get(0)[0]);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findAllByNombre() {

        List<Cliente> clientes = clienteRepo.findAllByNombre("Juan");
        clientes.forEach (System.out:: println);
        Assertions.assertEquals(2, clientes.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPorNombre() {

        List<Cliente> clientes = clienteRepo.buscarPorNombre("Pepe");
        clientes.forEach (System.out:: println);
        Assertions.assertEquals(1, clientes.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacion() {

        Optional<Cliente> clientes = clienteRepo.comprobarAutenticacion("juan@gmail.com", "5555");
        System.out.println(clientes.get());
        Assertions.assertNotNull(clientes.get());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findByEmailAndPassword() {

        Optional<Cliente> clientes = clienteRepo.findByEmail("pepe@gmail.com");
        System.out.println(clientes.get());
        Assertions.assertNotNull(clientes.get());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void findByEmail() {

        Optional<Cliente> clientes = clienteRepo.findByEmail("mario@gmail.com");
        System.out.println(clientes.get());
        Assertions.assertEquals("Mario", clientes.get().getNombre());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void findAll() {

        Page<Cliente> clientes = clienteRepo.findAll(Pageable.ofSize(2));
        clientes.forEach (System.out:: println);
        Assertions.assertEquals(2, clientes.getTotalPages());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerListaReserva() {

        List<Reserva> reservas = clienteRepo.obtenerListaReserva("Pepe@gamil.com");
        reservas.forEach (System.out:: println);
        Assertions.assertEquals(0, reservas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerListaReservaCedula() {

        List<Reserva> reservas = clienteRepo.obtenerListaReservaCedula("1234");
        reservas.forEach (System.out:: println);
        Assertions.assertEquals(1, reservas.size());
    }




    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuariosTelefono() {

        List<Cliente> clientes = clienteRepo.obtenerUsuariosTelefono();
        clientes.forEach(System.out:: println);
        Assertions.assertEquals(3, clientes.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComentariosCliente() {

        List<Comentario> comentarios = clienteRepo.obtenerComentariosCliente("1234");
        comentarios.forEach(System.out:: println);
        Assertions.assertEquals(2, comentarios.size());
    }


}
