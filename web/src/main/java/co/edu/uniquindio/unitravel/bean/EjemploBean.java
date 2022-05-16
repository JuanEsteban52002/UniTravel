package co.edu.uniquindio.unitravel.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
@Getter
@Setter
public class EjemploBean implements Serializable {

    private String atributoUno, atributoDos;

    public void cambiarValores(){
        String aux = atributoUno;
        atributoUno = atributoDos;
        atributoDos = aux;
    }
}
