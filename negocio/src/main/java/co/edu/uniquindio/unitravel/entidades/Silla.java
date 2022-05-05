package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
@ToString

public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false, length = 5)
    private String posicion;

    @Column(nullable = false, length = 50)
    private double precio;

    @ManyToOne
    private Vuelo vuelo;

    @ToString.Exclude
    @OneToMany(mappedBy = "silla")
    private List<ReservaSilla> reservasSillas;

    public Silla(String codigo, String posicion, double precio) {
        this.codigo = codigo;
        this.posicion = posicion;
        this.precio = precio;
    }
}
