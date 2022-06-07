package co.edu.uniquindio.unitravel.bean;


import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
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
import java.util.Date;
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

    @Getter @Setter
    private AdministradorHotel administradorHotel;

    @PostConstruct
    public void inicializar(){
        nuevoComentario = new Comentario();
        comentarios = new ArrayList<Comentario>();

        if(codigoHotel != null && !codigoHotel.isEmpty()){
            try{
                hotel = unitravelServicio.obtenerHotel(Integer.parseInt(codigoHotel));
                administradorHotel = hotel.getAdministradorHotel();
                comentarios = hotel.getComentarios();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    public List<Habitacion> habitacionesDisponibles(Date fechaInicio, Date fechaFin){

        List<Reserva> reservas = unitravelServicio.reservasIntervalo(fechaInicio, fechaFin);

        List<Habitacion> habitaciones = hotel.getHabitaciones();
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        boolean centinela = false;

        for(Reserva r : reservas){
            for(ReservaHabitacion rh : r.getReservasHabitaciones()){
                for(int i = 0; i < habitaciones.size() ; i++){
                    if(Integer.parseInt(rh.getCodigo()) == habitaciones.get(i).getNumero()){
                        centinela = true;
                    }
                }
                if(centinela == false){

                }
            }
        }


        return habitacionesDisponibles;
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
