package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio{

    private ClienteRepo clienteRepo;
    private ReservaRepo reservaRepo;
    private ComentarioRepo comentarioRepo;
    private HotelRepo hotelRepo;
    private CiudadRepo ciudadRepo;
    private EmailServicio emailServicio;

    public ClienteServicioImpl(ClienteRepo clienteRepo,
                               ReservaRepo reservaRepo,
                               ComentarioRepo comentarioRepo,
                               HotelRepo hotelRepo,
                               CiudadRepo ciudadRepo,
                               EmailServicio emailServicio) {
        this.clienteRepo = clienteRepo;
        this.reservaRepo = reservaRepo;
        this.comentarioRepo = comentarioRepo;
        this.hotelRepo = hotelRepo;
        this.ciudadRepo = ciudadRepo;
        this.emailServicio = emailServicio;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente)  throws Exception{

        Cliente clienteBuscado = clienteRepo.findById(cliente.getCedula()).orElse(null);

        if(clienteBuscado != null){
            throw new Exception("El cliente ya existe");
        }

        Cliente clienteEmail = clienteRepo.findByEmail(cliente.getEmail()).orElse(null);

        if(clienteEmail != null){
            throw new Exception("Ya existe alguien usando este correo");
        }

        return clienteRepo.save(cliente);
    }

    public Cliente buscarPorEmail(String email) throws Exception{

        if(email.isEmpty()){
            throw new Exception("Por favor escribir un correo");
        }
        Cliente cliente = clienteRepo.findByEmail(email).orElse(null);

        if(cliente == null){
            throw  new Exception("No hay ningun ningun con este correo");
        }
        return cliente;
    }

    @Override
    public Cliente obtenerCliente(String codigo)  throws Exception{

        if(codigo.isEmpty()){
            throw new Exception("Por favor ingrese una cedula");
        }
        Cliente cliente = clienteRepo.findById(codigo).orElse(null);

        return cliente;
    }


    @Override
    public Cliente actualizarCliente(Cliente cliente)  throws Exception{

        if (cliente == null){
            throw new Exception("Error en los datos, cliente inexistente");
        }

        return clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void eliminarCliente(String cedula)  throws Exception{

        if(cedula.isEmpty()){
            throw new Exception("Porfavor ingrese una cedula");
        }

        Cliente cliente = obtenerCliente(cedula);

        if(cliente == null){
            throw new Exception("El cliente no existe");
        }
        clienteRepo.delete(cliente);
    }

    @Override
    public Cliente validarLogin(String correo, String password) throws Exception {

        if(correo.isEmpty()){
            throw new Exception("Porfavor ingrese un correo");
        }

        if(password.isEmpty()){
            throw new Exception("Porfavor ingrese una contraseña");
        }

        Optional<Cliente> cliente = clienteRepo.findByEmailAndPassword(correo, password);

        if(cliente.equals(null)){
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
        comentario.setFechaCalificacion(LocalDateTime.now());

        return comentarioRepo.save(comentario);
    }

    @Override
    public void eliminarComentario(Integer codigo) throws Exception {

        Comentario comentarioBuscado = obtenerComentario(codigo);

        if(comentarioBuscado == null){
            throw new Exception("El comentario no existe");
        }

        comentarioRepo.delete(comentarioBuscado);
    }

    @Override
    public Comentario modificarComentario(Comentario comentario) throws Exception {
        return comentarioRepo.save(comentario);
    }

    public Comentario obtenerComentario(Integer codigo) throws Exception {
        return comentarioRepo.findById(String.valueOf(codigo)).orElse(null);
    }

    @Override
    public Reserva hacerReserva(Reserva reserva) throws Exception {

        if(reserva == null){
            throw new Exception("Reserva vacia, verifique la informacion");
        }

        //Revisa que las habitaciones esten disponibles
        if (reserva.getReservasHabitaciones() == null){
            throw new Exception("No hay habitaciones disponibles");
        }
        for (int i = 0; i < reserva.getReservasHabitaciones().size(); i++) {
            ReservaHabitacion habitacion = reserva.getReservasHabitaciones().get(i);

            if(!revisarHabitacionDisponible(habitacion)){
                if (!revisarHabitacionReservadaSegunFecha(reserva, habitacion)) {
                    throw new Exception("La habitacion con codigo: " + habitacion.getCodigo() + ", se encuentra ocupada");
                }
            }
        }
        //Revisa que las sillas esten disponibles
        for (int i = 0; i < reserva.getReservasSillas().size(); i++) {
            ReservaSilla silla = reserva.getReservasSillas().get(i);
            Vuelo vuelo = silla.getSilla().getVuelo();
            if(!sillaDisponible(silla, vuelo)){
                throw new Exception("La silla: " + silla.getCodigo() + ", no esta disponible");
            }
        }

        return reserva;
    }

    private boolean sillaDisponible(ReservaSilla sillaReservada, Vuelo vuelo) {

        List<Silla> sillas = vuelo.getSillas();
        for (Silla silla : sillas){
            if(silla.getCodigo() == sillaReservada.getCodigo()){
                if(silla.getEstadoSilla() == EstadoSilla.DISPONIBLE){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean revisarHabitacionReservadaSegunFecha(Reserva reserva, ReservaHabitacion habitaconA) {

        List<Reserva> reservasSegunFecha = reservaRepo.devolverReservaIntervaloFecha(reserva.getFechaInicio(), reserva.getFechaFin());
        for(Reserva reservas : reservasSegunFecha){
            List<ReservaHabitacion> habitacionesReservadas = reservas.getReservasHabitaciones();
            for (int i = 0; i < habitacionesReservadas.size(); i++) {
                ReservaHabitacion habitacion = habitacionesReservadas.get(i);
                if(habitacion.getCodigo() == habitaconA.getCodigo()){
                    return false;
                }
            }

        }
        return true;
    }

    private boolean revisarHabitacionDisponible(ReservaHabitacion habitacionActual) {

        List<ReservaHabitacion> habitacionesReservadas = reservaRepo.habitacionesReservadas();
        for(ReservaHabitacion habitacion : habitacionesReservadas){
           if(habitacion.getCodigo() == habitacionActual.getCodigo()){
               return false;
           }
        }
        return true;
    }

    @Override
    public void eliminarReserva(String codigoReserva) throws Exception {
        Optional<Reserva> reserva = reservaRepo.findById(codigoReserva);

        if(reserva.equals(null)){
            throw new Exception("La reserva no existe");
        }else{
            reservaRepo.delete(reserva.get());
        }
    }

    @Override
    public Reserva modificarReserva(Reserva reserva) throws Exception {

        if(reserva == null){
            throw new Exception("Ingrese los datos correctamente");
        }
        return reservaRepo.save(reserva);
    }

    @Override
    public List<Hotel> buscarHotelesCiudad(String nombreCiudad) {
        return hotelRepo.obtenerHotelesCiudad(nombreCiudad);
    }

    @Override
    public List<Hotel> buscarHotelesNombre(String nombreHotel) {
        return hotelRepo.obtenerHotelesNombre(nombreHotel);
    }

    @Override
    public List<Reserva> listarReservasCliente(String emailCliente) {
        return clienteRepo.obtenerListaReserva(emailCliente);
    }

    @Override
    public void recuperarPassword(String email) throws Exception {
        Optional<Cliente> cliente = clienteRepo.findByEmail(email);

        if(cliente.equals(null)){
            throw new Exception("El email no pertenece a ningun usuario");
        }

        String password = cliente.get().getPassword();
        emailServicio.enviarMail("Recuperación de contraseña", "Hola, "+cliente.get().getNombre()+
                " su contraseña es: " +password, email);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        return ciudadRepo.findById(codigo).orElse(null);
    }

    @Override
    public List<Hotel> listarHoteles() {
        return hotelRepo.findAll();
    }
}
