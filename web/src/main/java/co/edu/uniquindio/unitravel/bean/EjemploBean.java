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

    private String atributo1, atributo2;

    public void cambiarValores() {
        String aux = atributo1;
        atributo1 = atributo2;
        atributo2 = aux;
    }
}
