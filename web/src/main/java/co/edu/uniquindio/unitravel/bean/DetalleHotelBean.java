package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class DetalleHotelBean implements Serializable {

    private AdministradorHotelServicio administradorHotelServicio;

    @Value("#{param['hotel_id']")
    private String codigoHotel;

    @Getter @Setter
    private Hotel hotel;

    {
        try {
            hotel = administradorHotelServicio.obtenerHotel(Integer.parseInt(codigoHotel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
