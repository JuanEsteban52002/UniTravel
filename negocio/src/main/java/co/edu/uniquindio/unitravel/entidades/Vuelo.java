package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Vuelo implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 25)
    private String codigo;

    private Estado estado;

    @Column(nullable = false, length = 50)
    private String aerolinea;

    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;

    @ToString.Exclude
    @OneToMany(mappedBy = "vuelo")
    private List<Silla> sillas;

    public Vuelo(String codigo,Estado estado, String aerolinea) {
        this.codigo = codigo;
        this.estado = estado;
        this.aerolinea = aerolinea;
    }
}
