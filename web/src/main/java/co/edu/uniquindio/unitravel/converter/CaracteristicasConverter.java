package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelUtilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class CaracteristicasConverter implements Serializable, Converter<Caracteristica> {

    @Autowired
    private UnitravelUtilServicio unitravelUtilServicio;

    @Override
    public Caracteristica getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            Caracteristica caracteristica = unitravelUtilServicio.obtenerCaracteristica(Integer.parseInt(value));
            return caracteristica;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Caracteristica value) {
        if (!value.equals(null)) {
            return Integer.toString(value.getCodigo());
        }
        return "";
    }
}
