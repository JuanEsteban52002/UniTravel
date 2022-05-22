package co.edu.uniquindio.unitravel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FotoTest {

    @Autowired
    private FotoRepo fotorepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Foto foto = new Foto("4", "foto4.jpg");
        Foto fotoGuardada = fotorepo.save(foto);

        Assertions.assertNotNull(fotoGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Foto foto = fotorepo.findById("1").orElse(null);
        foto.setUrl("fotoHabitacion2.jpg");
        fotorepo.save(foto);
        fotorepo.findById("1").orElse(null);
        Assertions.assertEquals("fotoHabitacion2.jpg", foto.getUrl());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        fotorepo.deleteById("1");
        Foto foto = fotorepo.findById("1").orElse(null);
        Assertions.assertNull(foto);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Foto> fotos = fotorepo.findAll();
        fotos.forEach (System.out:: println);
    }

}
