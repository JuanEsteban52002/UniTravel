package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString

public class Caracteristica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @ToString.Exclude
    @ManyToMany
    private List<Hotel> hoteles;

    @ToString.Exclude
    @ManyToMany
    private List<Habitacion> habitaciones;

    public Caracteristica(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
