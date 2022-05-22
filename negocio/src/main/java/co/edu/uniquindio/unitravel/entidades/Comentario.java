package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString

public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private int calificacion;

    @Column(nullable = false)
    @PastOrPresent
    private LocalDateTime fechaCalificacion;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Cliente cliente;

    public Comentario(Integer codigo, String comentario, int calificacion ){
        this.codigo = codigo;
        this.comentario = comentario;
        this.fechaCalificacion = LocalDateTime.now();
        this.calificacion = calificacion;
    }

}
