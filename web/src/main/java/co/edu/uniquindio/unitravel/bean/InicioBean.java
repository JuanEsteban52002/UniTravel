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
public class InicioBean implements Serializable {


    public String irRegistro(){
        return "registrar_cliente?faces-redirect=true";
    }
}
