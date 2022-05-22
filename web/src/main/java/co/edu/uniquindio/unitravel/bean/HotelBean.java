package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelUtilServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class HotelBean implements Serializable {

    @Getter @Setter
    private Hotel hotel;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Autowired
    private UnitravelUtilServicio unitravelUtilServicio;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Setter @Getter
    private List<Caracteristica> caracteristicas;


    //-------------------------------------------//
    @PostConstruct
    public void inicializar(){

        hotel = new Hotel();
        imagenes = new ArrayList<>();
        ciudades = administradorHotelServicio.listarCiudades();
        caracteristicas = unitravelUtilServicio.listarCaracteristicasHotel();
    }

    @Value("${upload.url}")
    private String urlImagenes;

    private List<String> imagenes;

    public String registrarHotel(){
        try {

            if(imagenes.size() > 10) {

                hotel.setCiudad(administradorHotelServicio.obtenerCiudad(1));
                hotel.setAdministradorHotel(administradorHotelServicio.obtenerAdministradorHotel("111"));
                hotel.setFotos(imagenes);

                administradorHotelServicio.crearHotel(hotel);
                // FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Hotel creado exitosamente");
                // FacesContext.getCurrentInstance().addMessage(null, msj);
                return "registro_exitoso?faces-redirect=true";
            }else{
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Es obligatorio subir imagenes al hotel");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            }

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
        return null;
    }

    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null) {
            imagenes.add(nombreImagen);
        }
    }

    private String subirImagen(UploadedFile imagen) {
        try {
            File archivo = new File(urlImagenes + "/" + imagen.getFileName());
            OutputStream outPutStream = new FileOutputStream(archivo);
            IOUtils.copy(imagen.getInputStream(), outPutStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
