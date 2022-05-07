package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

    @Query("select r.precioTotal from Cliente c join c.reservas r where c.cedula= :cedula and r.codigo= :codigoReserva")
    double obtenerPrecioReserva(String cedula, String codigoReserva);

    @Query("select sum(r.precioTotal) from Cliente c join c.reservas r where c.cedula= :cedula")
    double obtenerTotalPrecioReservas(String cedula);

    @Query("select r.codigo, r.fechaInicio, r.fechaFin, r.precioTotal from Cliente c join c.reservas r where c.cedula= :cedula")
    List<Object[]> devolverDetalleReservaSegunCliente(String cedula);

    @Query("select c, r from Reserva r join r.cliente c group by c ")
    List<Object[]> obtenerReservasClientes();

    List<Cliente> findAllByNombre(String nombre);

    @Query("select c from Cliente c where  c.nombre = :nombre")
    List<Cliente> buscarPorNombre(String nombre);

    @Query("select  c from Cliente c where c.email = :email and c.password = :password ")
    Optional<Cliente> comprobarAutenticacion(String email, String password);

    Optional<Cliente> findByEmailAndPassword(String email, String password);

    Optional<Cliente> findByEmail(String email);

    Page<Cliente> findAll(Pageable pageable);

    @Query("select r from Cliente c join c.reservas r where c.email = :email")
    List<Reserva> obtenerListaReserva(String email);

    @Query("select r from Cliente c join c.reservas r where c.cedula = :cedula")
    List<Reserva> obtenerListaReservaCedula(String cedula);

    //distinct, evita que se repita datos
    @Query("select distinct c from Cliente c join c.telefonos")
    List<Cliente> obtenerUsuariosTelefono();

    @Query("select co from Cliente c join c.comentarios co where c.cedula= :cedula")
    List<Comentario> obtenerComentariosCliente(String cedula);

}
