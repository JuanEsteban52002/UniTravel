package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
        try {
            clienteServicio.registrarCliente(cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
