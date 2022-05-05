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

public class Habitacion implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    private int numero;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private String capacidad;


    @ToString.Exclude
    @OneToMany(mappedBy = "habitacion")
    private List<Cama> camas;

    @ToString.Exclude
    @OneToMany(mappedBy = "habitacion")
    private List<Foto> fotos;

    @ManyToOne
    private Hotel hotel;

    @ToString.Exclude
    @ManyToMany(mappedBy = "habitaciones")
    private List<Caracteristica> caracteristicas;

    @ToString.Exclude
    @OneToMany(mappedBy = "habitacion")
    private List<ReservaHabitacion> reservasHabitaciones;

    public Habitacion(int numero, double precio, String capacidad) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = capacidad;
    }
}
