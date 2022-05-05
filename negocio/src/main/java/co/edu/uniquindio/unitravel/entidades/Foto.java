package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString

public class Foto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Habitacion habitacion;


    public Foto(String codigo, String url) {
        this.codigo = codigo;
        this.url = url;
    }
}
