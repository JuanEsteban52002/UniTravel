package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Carro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String placa;

    @Column(length = 4, nullable = false)
    private int modelo;

    @Min(1)
    private int cantidadPasajeros;

    @Min(0)
    @Max(1)
    private int aireAcondicionado;

    private double precio;

    @Min(0)
    @Max(1)
    private int estado;

    @Min(0)
    @Max(1)
    private int transimision;

    @ManyToOne
    private Aeropuerto aeropuerto;

    public Carro(String placa, int modelo, int cantidadPasajeros, int aireAcondicionado, int estado, int transimision) {
        this.placa = placa;
        this.modelo = modelo;
        this.cantidadPasajeros = cantidadPasajeros;
        this.aireAcondicionado = aireAcondicionado;
        this.estado = estado;
        this.transimision = transimision;

    }
}
