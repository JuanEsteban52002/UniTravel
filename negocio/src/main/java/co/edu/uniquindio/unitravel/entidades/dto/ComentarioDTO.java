package co.edu.uniquindio.unitravel.entidades.dto;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class ComentarioDTO {

    private List<Comentario> comentario;
    private String emailUsuario;
}
