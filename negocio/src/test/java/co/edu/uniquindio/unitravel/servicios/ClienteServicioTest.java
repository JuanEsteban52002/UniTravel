package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void hacerReservaTest(){
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void modificarReservaTest(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservasClienteTest(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarReservaTest(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentarioTest(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarComentarioTest(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void recuperarPasswordTest(){

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
