package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CaracteristicaTest {

    @Autowired
    private CaracteristicaRepo caracteristicaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Caracteristica caracteristica = new Caracteristica(3, "Aire acondicionado");
        Caracteristica caracteristicaGuardada = caracteristicaRepo.save(caracteristica);

        Assertions.assertNotNull(caracteristicaGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Caracteristica caracteristica = caracteristicaRepo.findById("1").orElse(null);
        caracteristica.setNombre("Si hay internet");
        caracteristicaRepo.save(caracteristica);
        caracteristicaRepo.findById("1").orElse(null);
        Assertions.assertEquals("Si hay internet", caracteristica.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        caracteristicaRepo.deleteById("1");
        Caracteristica caracteristica = caracteristicaRepo.findById("1").orElse(null);
        Assertions.assertNull(caracteristica);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Caracteristica> caracteristicas = caracteristicaRepo.findAll();
        caracteristicas.forEach (System.out:: println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  obtenerHotelesCaracteristica() {

        List<Hotel> lista = caracteristicaRepo.obtenerHotelesCaracteristica("Hay camas");
        lista.forEach (System.out:: println);
        Assertions.assertEquals(1, lista.size());
    }

}
