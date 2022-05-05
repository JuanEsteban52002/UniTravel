package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;

import java.util.List;

public interface ClienteServicio {

    //Gestionar cliente
    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente obtenerCliente(String codigo) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    List<Cliente> listarCliente(Cliente cliente) ;

    void eliminarCliente(String cedula) throws Exception;

    //LOGIN

    Cliente validarLogin(String correo, String password) throws Exception;

    //COMENTARIO

    Comentario crearComentario(Comentario comentario) throws Exception;

    void eliminarComentario(Comentario comentario) throws Exception;

    Comentario modificarComentario(Comentario comentario) throws Exception;

    //Gestionar reserva

    Reserva hacerReserva(Reserva reserva) throws Exception;

    void eliminarReserva(String codigoReserva)throws Exception;

    Reserva modificarReserva(Reserva reserva)throws Exception;

    List<Reserva> listarReservasCliente(String emailCliente);

    //Buscar hoteles

    List<Hotel> buscarHotelesCiudad(String nombreCiudad);

    //Email

    void recuperarPassword(String email) throws Exception;
}
