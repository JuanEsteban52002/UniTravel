package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
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
    @Getter @Setter
    private Habitacion habitacion;
    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;
    @Autowired
    private UnitravelUtilServicio unitravelUtilServicio;
    @Getter @Setter
    private List<Ciudad> ciudades;
    @Getter @Setter
    private List<String> imagenesHotel;
    @Getter @Setter
    private List<String> imagenesHabitacion;
    @Getter @Setter
    private List<Caracteristica> caracteristicasHotel;
    @Getter @Setter
    private List<Caracteristica> caracteristicasHabitacion;
    @Getter @Setter
    private List<Habitacion> habitaciones;
    @Getter @Setter
    private List<Cama> camas;

    @Value(value = "#{seguridadBean.persona}")
    private Persona personaSesion;


    //-------------------------------------------//
    @PostConstruct
    public void inicializar() throws Exception {

        hotel = new Hotel();
        imagenesHotel = new ArrayList<String>();
        imagenesHabitacion = new ArrayList<String>();
        habitacion = new Habitacion();
        habitaciones = new ArrayList<>();
        ciudades = administradorHotelServicio.listarCiudades();
        caracteristicasHotel = unitravelUtilServicio.listarCaracteristicasHotel();
        caracteristicasHabitacion = unitravelUtilServicio.listarCaracteristicasHabitacion();
        camas = unitravelUtilServicio.listarCamas();
    }

    @Value("${upload.url}")
    private String urlImagenes;


    public String registrarHotel(){
        try {

            if(personaSesion != null) {


                if (imagenesHotel.size() >= 1) {
                    if (true){
                    //if (habitaciones.size() > 0) {
                        hotel.setAdministradorHotel((AdministradorHotel) personaSesion);
                        hotel.setFotos(imagenesHotel);
                        hotel.setCodigo(100);

                        Hotel h = administradorHotelServicio.crearHotel(hotel);

                        habitaciones.forEach(hab -> {

                            hab.setHotel(h);
                            administradorHotelServicio.crearHabitacion(hab);
                        });
                        return "/admin_hotel/registroExitoso?faces-redirect=true";

                    } else {
                        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Es obligatorio agregar habitaciones");
                        FacesContext.getCurrentInstance().addMessage("msj_bean", msj);
                    }
                } else {
                    FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Es obligatorio subir imagenes");
                    FacesContext.getCurrentInstance().addMessage("msj_bean", msj);
                }
            }

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj_bean", msj);
            System.out.println("ERROR: " + e.getMessage());
        }

        return null;
    }

    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null) {
            imagenesHotel.add(nombreImagen);
        }
    }

    private String subirImagen(UploadedFile imagen) {
        try {
            File archivo = new File(urlImagenes + "/" + imagen.getFileName());
            OutputStream outPutStream = new FileOutputStream(archivo);
            IOUtils.copy(imagen.getInputStream(), outPutStream);
            return imagen.getFileName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void crearHabitacion(){
        if(!imagenesHabitacion.isEmpty()){


            habitacion = new Habitacion();
            imagenesHabitacion = new ArrayList<>();


        }else{
            FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Es obligatorio asignarle habitaciones al hotel");
            FacesContext.getCurrentInstance().addMessage("msj_bean", ms);
        }
    }
}
