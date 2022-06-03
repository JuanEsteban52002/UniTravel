package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class CamaConverter implements Converter<Cama>, Serializable {

    @Autowired
    private AdministradorHotelServicio administradorHotel;


    @Override
    public Cama getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            Cama cama = administradorHotel.obtenerCama(Integer.parseInt(value));
            return cama;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String getAsString(FacesContext context, UIComponent component, Cama value) {

        if (value != null) {
            String valor = value.getCodigo()+"";
            return valor;
        }
        return "";
    }
}
