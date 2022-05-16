package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class HotelBean implements Serializable {

    @Getter @Setter
    private Hotel hotel;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @PostConstruct
    public void inicializar(){
        hotel = new Hotel();
    }

    public String registrarHotel(){
        try {

            hotel.setCiudad(administradorHotelServicio.obtenerCiudad(1));
            hotel.setAdministradorHotel(administradorHotelServicio.obtenerAdministradorHotel("111"));

            administradorHotelServicio.crearHotel(hotel);
           // FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Hotel creado exitosamente");
           // FacesContext.getCurrentInstance().addMessage(null, msj);
            return "registro_exitoso?faces-redirect=true";

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
        return null;
    }

}
