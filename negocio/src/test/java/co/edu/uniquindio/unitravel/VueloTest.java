package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Estado;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.entidades.dto.VuelosCiudadDTO;
import co.edu.uniquindio.unitravel.repositorios.VueloRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class VueloTest {

    @Autowired
    private VueloRepo vueloRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Vuelo vuelo = new Vuelo("V1", Estado.DISPONIBLE , "Avianca");
        Vuelo vueloGuardado = vueloRepo.save(vuelo);

        Assertions.assertNotNull(vueloGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Vuelo vuelo = vueloRepo.findById("1").orElse(null);
        vuelo.setAerolinea("Viva Aerobus");
        vueloRepo.save(vuelo);
        vueloRepo.findById("1").orElse(null);
        Assertions.assertEquals("Viva Aerobus", vuelo.getAerolinea());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        vueloRepo.deleteById("1");
        Vuelo vuelo = vueloRepo.findById("1").orElse(null);
        Assertions.assertNull(vuelo);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Vuelo> vuelos = vueloRepo.findAll();
        vuelos.forEach (System.out:: println);
    }

    /*
                Consultas
     */

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerVuelos() {

        List<Vuelo> vuelos = vueloRepo.obtenerVuelos("Bogota");
        vuelos.forEach(System.out::println);
        Assertions.assertEquals(1, vuelos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void contarVuelosPorCiudad() {

        List<VuelosCiudadDTO> vuelos = vueloRepo.contarVuelosPorCiudad();
        vuelos.forEach(System.out::println);
        Assertions.assertEquals(3, vuelos.size());
    }


}
