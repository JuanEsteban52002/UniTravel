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
public class BusquedaBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter @Setter
    private String busqueda;

    @Value("#{param['busqueda']}")
    private String busquedaParametro;

    @Getter @Setter
    private List<Hotel> hoteles;

    @PostConstruct
    public void inicializar(){

        hoteles = new ArrayList<>();

        try{
            if(busquedaParametro!=null && !busquedaParametro.isEmpty()) {
                hoteles = clienteServicio.buscarHotelesNombre(busquedaParametro);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String buscar(){
        System.out.println("busqueda: " + busqueda);
        System.out.println("busquedaParametro: " + busquedaParametro);
        return "resultado_busqueda?faces-redirect=true&amp;busqueda="+busqueda;
    }


}
