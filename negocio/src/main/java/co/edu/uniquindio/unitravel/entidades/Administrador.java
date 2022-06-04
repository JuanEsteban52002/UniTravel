package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(callSuper = true)

public class Administrador extends Persona implements Serializable {

    public Administrador(String cedula, String nombre, @Email String email, String password) {
        super(cedula, nombre, email, password);
    }
}
