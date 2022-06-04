package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    @Size(max = 10, message = "El codigo debe tener maximo 10 caracteres")
    private String cedula;

    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "El nombre debe tener maximo 100 caracteres")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @Email(message = "El formato del correo no es valido")
    @Column(nullable = false, unique = true, length = 100)
    @Size(max = 100, message = "El correo debe tener maximo 100 caracteres")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "La contraseña no puede estar vacia")
     private String password;


}
