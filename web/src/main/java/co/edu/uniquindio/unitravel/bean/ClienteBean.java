package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
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
public class ClienteBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter @Setter
    private Cliente cliente;

    @PostConstruct
    public void init() {

        cliente = new Cliente();
    }

    public void registrarCliente() {
        System.out.println("Cliente "+cliente.getCedula());
        System.out.println("Cliente servicio: "+clienteServicio);
        try {
            clienteServicio.registrarCliente(cliente);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente registrado", "Cliente registrado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
        System.out.println("FIn del metodo");
    }
}
