package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
import co.edu.uniquindio.unitravel.repositorios.ComentarioRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio{

    private ClienteRepo clienteRepo;
    private ReservaRepo reservaRepo;
    private ComentarioRepo comentarioRepo;
    private HotelRepo hotelRepo;
    private EmailServicio emailServicio;

    public ClienteServicioImpl(ClienteRepo clienteRepo,
                               ReservaRepo reservaRepo,
                               ComentarioRepo comentarioRepo,
                               HotelRepo hotelRepo,
                               EmailServicio emailServicio) {
        this.clienteRepo = clienteRepo;
        this.reservaRepo = reservaRepo;
        this.comentarioRepo = comentarioRepo;
        this.hotelRepo = hotelRepo;
        this.emailServicio = emailServicio;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente)  throws Exception{

        Cliente clienteBuscado = obtenerCliente(cliente.getCedula());

        if(clienteBuscado != null){
            throw new Exception("El cliente ya existe");
        }

        Cliente clienteEmail = buscarPorEmail(cliente.getEmail());

        if(clienteEmail != null){
            throw new Exception("El email ya existe");
        }

        return clienteRepo.save(cliente);
    }

    public Cliente buscarPorEmail(String email){
        return clienteRepo.findByEmail(email).orElse(null);
    }

    @Override
    public Cliente obtenerCliente(String codigo)  throws Exception{
        return clienteRepo.findById(codigo).orElse(null);
    }


    @Override
    public Cliente actualizarCliente(Cliente cliente)  throws Exception{
        return clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void eliminarCliente(String cedula)  throws Exception{
        Cliente cliente = obtenerCliente(cedula);

        if(cliente == null){
            throw new Exception("El cliente no existe");
        }
        clienteRepo.delete(cliente);
    }

    @Override
    public Cliente validarLogin(String correo, String password) throws Exception {

        Optional<Cliente> cliente = clienteRepo.findByEmailAndPassword(correo, password);

        if(cliente.isEmpty()){
            throw new Exception("Los datos de autenticación son incorrectos");
        }
        return cliente.get();
    }

    @Override
    public Comentario crearComentario(Comentario comentario) throws Exception {

        Comentario comentarioBuscado = obtenerComentario(comentario.getCodigo());

        if(comentarioBuscado != null){
            throw new Exception("El comentario ya existe");
        }

        return comentarioRepo.save(comentario);
    }

    @Override
    public void eliminarComentario(Comentario comentario) throws Exception {

        Comentario comentarioBuscado = obtenerComentario(comentario.getCodigo());

        if(comentarioBuscado == null){
            throw new Exception("El comentario no existe");
        }

        comentarioRepo.delete(comentario);
    }

    @Override
    public Comentario modificarComentario(Comentario comentario) throws Exception {
        return comentarioRepo.save(comentario);
    }

    public Comentario obtenerComentario(String codigo) throws Exception {
        return comentarioRepo.findById(codigo).orElse(null);
    }

    @Override
    public Reserva hacerReserva(Reserva reserva) {
        return null;
    }

    @Override
    public void eliminarReserva(String codigoReserva) throws Exception {
        Optional<Reserva> reserva = reservaRepo.findById(codigoReserva);

        if(reserva.isEmpty()){
            throw new Exception("La reserva no existe");
        }else{
            reservaRepo.delete(reserva.get());
        }
    }

    @Override
    public Reserva modificarReserva(Reserva reserva) throws Exception {
        return null;
    }

    @Override
    public List<Hotel> buscarHotelesCiudad(String nombreCiudad) {
        return hotelRepo.obtenerHotelesCiudad(nombreCiudad);
    }

    @Override
    public List<Reserva> listarReservasCliente(String emailCliente) {
        return clienteRepo.obtenerListaReserva(emailCliente);
    }

    @Override
    public void recuperarPassword(String email) throws Exception {
        Optional<Cliente> cliente = clienteRepo.findByEmail(email);

        if(cliente.isEmpty()){
            throw new Exception("El email no pertenece a ningun usuario");
        }

        String password = cliente.get().getPassword();
        emailServicio.enviarMail("Recuperación de contraseña", "Hola, "+cliente.get().getNombre()+
                " su contraseña es: " +password, "email");
    }
}
