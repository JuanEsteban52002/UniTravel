package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class Cliente extends Persona implements Serializable {

    @ManyToOne
    private Ciudad ciudad;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Comentario> comentarios;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Telefono> telefonos;


    public Cliente(String cedula, String nombre, @Email String email, String password) {
        super(cedula, nombre, email, password);
    }
}
