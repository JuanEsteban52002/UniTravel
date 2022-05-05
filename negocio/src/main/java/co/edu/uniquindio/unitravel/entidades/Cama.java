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

public class Cama implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private int codigo;

    @Column(nullable = false, length = 50)
    private String tipo;

    @ManyToOne
    private Habitacion habitacion;

    public Cama(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }
}
