package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Aeropuerto;
import co.edu.uniquindio.unitravel.entidades.Carro;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.AeropuertoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AeropuertoTest {

    @Autowired
    private AeropuertoRepo aeropuertoRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Aeropuerto aeropuerto = new Aeropuerto("A4", "Aeropuerto 4", "Carrera 2");
        Aeropuerto aeropuertoGuardado = aeropuertoRepo.save(aeropuerto);

        Assertions.assertNotNull(aeropuertoGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Aeropuerto aeropuerto = aeropuertoRepo.findById("A2").orElse(null);
        aeropuerto.setNombre("Aeropuerto Nueva Esperanza");
        aeropuertoRepo.save(aeropuerto);
        aeropuertoRepo.findById("A2").orElse(null);
        Assertions.assertEquals("Aeropuerto Nueva Esperanza", aeropuerto.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        aeropuertoRepo.deleteById("A1");
        Aeropuerto aeropuerto = aeropuertoRepo.findById("A1").orElse(null);
        Assertions.assertNull(aeropuerto);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Aeropuerto> aeropuertos = aeropuertoRepo.findAll();
        aeropuertos.forEach (System.out:: println);
    }
}
