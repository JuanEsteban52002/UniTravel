package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Reserva implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @PastOrPresent
    private Date fechaReserva;

    @FutureOrPresent
    private Date fechaInicio;

    @FutureOrPresent
    private Date fechaFin;

    private Alimentacion alimentacion;

    @Column(nullable = false)
    private double precioTotal;

    private EstadoReserva estado;

    @Min(1)
    private int cantidadPersonas;

    @ManyToOne
    private Cliente cliente;

    @ToString.Exclude
    @OneToMany(mappedBy = "reserva")
    private List<ReservaHabitacion> reservasHabitaciones;

    @ToString.Exclude
    @OneToMany(mappedBy = "reserva")
    private List<ReservaSilla> reservasSillas;

    public Reserva(String codigo, Date fechaReserva, Date fechaInicio, Date fechaFin, Alimentacion alimentacion, double precioTotal, EstadoReserva estado, int cantidadPersonas) {
        this.codigo = codigo;
        this.fechaReserva = fechaReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.alimentacion = alimentacion;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.cantidadPersonas = cantidadPersonas;
    }
}


