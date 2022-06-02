package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DestinoHotelBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;
    @Value("#{param['ciudad']}")
    private String codigoCiudadParametro;


    @Getter @Setter
    private List<Hotel> hoteles;

    @PostConstruct
    public void inicializar(){

        hoteles = new ArrayList<>();

        try{
            if(codigoCiudadParametro!=null && !codigoCiudadParametro.isEmpty()) {
                hoteles = clienteServicio.obtenerHotelesCodigoCiudad(Integer.parseInt(codigoCiudadParametro));
                hoteles.forEach(hotel -> System.out.println(hotel.getNombre()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
