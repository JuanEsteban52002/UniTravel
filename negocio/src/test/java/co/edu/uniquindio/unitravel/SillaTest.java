package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Silla;
import co.edu.uniquindio.unitravel.repositorios.SillaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SillaTest {

    @Autowired
    private SillaRepo sillaRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Silla silla = new Silla("S1", "A4", 70000);
        Silla sillaGuardada = sillaRepo.save(silla);

        Assertions.assertNotNull(sillaGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Silla silla = sillaRepo.findById("1").orElse(null);
        silla.setPrecio(60000);
        sillaRepo.save(silla);
        sillaRepo.findById("1").orElse(null);
        Assertions.assertEquals(60000, silla.getPrecio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        sillaRepo.deleteById("1");
        Silla silla = sillaRepo.findById("1").orElse(null);
        Assertions.assertNull(silla);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Silla> sillas = sillaRepo.findAll();
        sillas.forEach (System.out:: println);
    }
}
