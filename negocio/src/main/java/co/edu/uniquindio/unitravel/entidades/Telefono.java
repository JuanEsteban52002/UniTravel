package co.edu.uniquindio.unitravel.entidades;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Telefono implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 15)
    private String numTelefono;

    @Column(length = 50)
    private String descripcion;

    @ManyToOne
    private Cliente cliente;

    public Telefono(String numTelefono, String descripcion) {
        this.numTelefono = numTelefono;
        this.descripcion = descripcion;
    }
}
