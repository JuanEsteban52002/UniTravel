package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;

public interface ClienteServicio {

    //Gestionar cliente
    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente obtenerCliente(String codigo) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    List<Cliente> listarClientes() ;

    void eliminarCliente(String cedula) throws Exception;



    //COMENTARIO

    Comentario crearComentario(Comentario comentario) throws Exception;

    void eliminarComentario(Integer codigo) throws Exception;


    Comentario modificarComentario(Comentario comentario) throws Exception;

    //Gestionar reserva

    Reserva hacerReserva(Reserva reserva) throws Exception;

    void eliminarReserva(String codigoReserva)throws Exception;

    Reserva modificarReserva(Reserva reserva)throws Exception;

    List<Reserva> listarReservasCliente(String emailCliente);

    //Buscar hoteles

    List<Hotel> buscarHotelesCiudad(String nombreCiudad);

    List<Hotel> buscarHotelesNombre(String nombreHotel);

    //Email

    void recuperarPassword(String email) throws Exception;

    List<Ciudad> listarCiudades();

    Ciudad obtenerCiudad(Integer codigo) throws Exception;

    List<Hotel> listarHoteles();

}
