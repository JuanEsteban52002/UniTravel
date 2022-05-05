package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Aeropuerto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 15)
    private String codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String direccion;

    @ManyToOne
    private Ciudad ciudad;

    @ToString.Exclude
    @OneToMany(mappedBy = "aeropuerto")
    private List<Carro> carros;

    public Aeropuerto(String codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
