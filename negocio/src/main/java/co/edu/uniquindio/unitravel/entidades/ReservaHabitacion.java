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

public class ReservaHabitacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 20)
    private String codigo;

    @Column(nullable = false, length = 50)
    private double precio;

    @ManyToOne
    private Habitacion habitacion;

    @ManyToOne
    private Reserva reserva;

    public ReservaHabitacion(String codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }
}
