package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Aeropuerto;
import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.repositorios.CamaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CamaTest {

    @Autowired
    private CamaRepo camaRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {


        Cama cama = new Cama(4, "Doble");
        Cama camaGuardada = camaRepo.save(cama);

        Assertions.assertNotNull(camaGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Cama cama = camaRepo.findById(1).orElse(null);
        cama.setTipo("Doble");
        camaRepo.save(cama);
        camaRepo.findById(1).orElse(null);
        Assertions.assertEquals("Doble", cama.getTipo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        camaRepo.deleteById(1);
        Cama cama = camaRepo.findById(1).orElse(null);
        Assertions.assertNull(cama);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Cama> camas = camaRepo.findAll();
        camas.forEach (System.out:: println);
    }

}
