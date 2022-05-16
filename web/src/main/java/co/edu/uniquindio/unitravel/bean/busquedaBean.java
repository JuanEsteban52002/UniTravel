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
public class busquedaBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter @Setter
    private String busqueda;

    @Value("#{param['busqueda']}")
    private String busquedaParametro;

    private List<Hotel> hoteles;

    @PostConstruct
    public void inicializar(){
        if(busquedaParametro!=null && !busquedaParametro.isEmpty()) {
            hoteles = clienteServicio.buscarHotelesCiudad(busquedaParametro);
        }else{
            hoteles = new ArrayList<>();
        }
    }

    public String buscar(){
        List<Hotel> hoteles = clienteServicio.buscarHotelesCiudad(busqueda);
        return "resultado_busqueda?faces-redirect=true&amp;busqueda="+busqueda;

    }
}
