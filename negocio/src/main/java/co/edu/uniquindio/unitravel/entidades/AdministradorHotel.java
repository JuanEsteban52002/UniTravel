package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString(callSuper = true)

public class AdministradorHotel extends Persona implements Serializable {

    @ToString.Exclude
    @OneToMany(mappedBy = "administradorHotel")
    private List<Hotel> hoteles;

    public AdministradorHotel(String cedula, String nombre, @Email String email, String password) {
        super(cedula, nombre, email, password);
    }
}
