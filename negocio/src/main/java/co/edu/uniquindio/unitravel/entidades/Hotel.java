package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Getter
@Setter

public class Hotel implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Min(1)
    @Max(7)
    private int numEstrellas;

    @ManyToOne
    private AdministradorHotel administradorHotel;

    @ToString.Exclude
    @ManyToOne
    private Ciudad ciudad;

    @ToString.Exclude
    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @Column(nullable = false)
    private List<String> fotos;

    @ToString.Exclude
    @OneToMany(mappedBy = "hotel")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comentario> comentarios;

    @ToString.Exclude
    @ManyToMany(mappedBy = "hoteles")
    private List<Caracteristica> caracteristicas;

    @Lob
    private String descripcion;

    public Hotel(int codigo, String nombre, String direccion, String telefono, int numEstrellas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numEstrellas = numEstrellas;
    }

    public String getImagenPrincipal(){
        if(fotos != null){
            if(!fotos.isEmpty()){
                return fotos.get(0);
            }
        }
        return "defaultHotel.png";
    }
}
