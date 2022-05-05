package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;



    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Ciudad ciudad = new Ciudad(7, "Armenia");
        Ciudad ciudadGuardada = ciudadRepo.save(ciudad);

        Assertions.assertNotNull(ciudadGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Ciudad ciudad = ciudadRepo.findById(1).orElse(null);
        ciudad.setNombre("Barrancabermeja");
        ciudadRepo.save(ciudad);
        ciudadRepo.findById(1).orElse(null);
        Assertions.assertEquals("Barrancabermeja", ciudad.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        ciudadRepo.deleteById(1);
        Ciudad ciudad = ciudadRepo.findById(1).orElse(null);
        Assertions.assertNull(ciudad);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Ciudad> ciudades = ciudadRepo.findAll();
        ciudades.forEach (System.out:: println);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHoteles() {

        List<Hotel> hoteles = ciudadRepo.obtenerHoteles("Bogota");
        hoteles.forEach (System.out:: println);
        Assertions.assertEquals(2, hoteles.size());

    }

}
