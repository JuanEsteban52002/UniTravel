package co.edu.uniquindio.unitravel.bean;


import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelUtilImpl;
import co.edu.uniquindio.unitravel.servicios.UnitravelUtilServicio;
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
public class DetalleHotelBean implements Serializable {

    @Value("#{param['hotel_id']}")
    private String codigoHotel;

    @Getter @Setter
    private Comentario nuevoComentario;

    @Getter @Setter
    private Hotel hotel;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private UnitravelUtilServicio unitravelServicio;

    @Getter @Setter
    private List<Comentario> comentarios;

    @PostConstruct
    public void inicializar(){
        nuevoComentario = new Comentario();
        comentarios = new ArrayList<Comentario>();

        if(codigoHotel != null && !codigoHotel.isEmpty()){
            try{
                hotel = unitravelServicio.obtenerHotel(Integer.parseInt(codigoHotel));
                comentarios = hotel.getComentarios();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    public void crearComentario(){
        try {
            nuevoComentario.setHotel(this.hotel);
            nuevoComentario.setCliente(clienteServicio.obtenerCliente("113"));
            clienteServicio.crearComentario(nuevoComentario);
            this.comentarios.add(nuevoComentario);
            this.nuevoComentario = new Comentario();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
