package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Date;

@Component
@ViewScoped
public class ReservaBean implements Serializable {

    @Getter @Setter
    private Reserva reserva;
    @Getter @Setter
    private Date fechaDeReserva;
    @Getter @Setter
    private Date fechaDeInicio;
    @Getter @Setter
    private Date fechaDeFin;
}
