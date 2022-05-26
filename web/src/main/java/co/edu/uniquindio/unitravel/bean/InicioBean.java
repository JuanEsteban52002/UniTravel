package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class InicioBean implements Serializable {

    @Getter @Setter
    private List<Hotel> hoteles;


    @Getter @Setter
    private List<Ciudad> ciudades;

    @Autowired
    private ClienteServicio clienteServicio;

    @PostConstruct
    public void inicializar(){
        hoteles = clienteServicio.listarHoteles();
        ciudades = clienteServicio.listarCiudades();
    }

    public String irRegistro(){

        return "registrar_cliente?faces-redirect=true";
    }

    public String irDetalleHotel(String codigoHotel){
        return "detalle_hotel?faces-redirect=true&amp;hotel_id="+codigoHotel;
    }


}
