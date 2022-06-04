package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class ReservaSilla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 20)
    private String codigo;

    @Column(length = 50, nullable = false)
    private double precio;

    @ManyToOne
    private Silla silla;

    @ManyToOne
    private Reserva reserva;

    public ReservaSilla(String codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }
}
