package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private TipoCaracteritica tipoCaracteritica;

    @Column(length = 100, nullable = false)
    private String nombre;

    @ToString.Exclude
    @ManyToMany
    private List<Hotel> hoteles;

    @ToString.Exclude
    @ManyToMany
    private List<Habitacion> habitaciones;

    public Caracteristica(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
