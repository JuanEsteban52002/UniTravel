package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Telefono;
import co.edu.uniquindio.unitravel.repositorios.TelefonoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TelefonoTest {


    @Autowired
    private TelefonoRepo telefonoRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Telefono telefono = new Telefono("74225636", "Familiar");
        Telefono telefonoGuardado = telefonoRepo.save(telefono);

        Assertions.assertNotNull(telefonoGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Telefono telefono = telefonoRepo.findById("3183980410").orElse(null);
        telefono.setDescripcion("Familiar");
        telefonoRepo.save(telefono);
        telefonoRepo.findById("3183980410").orElse(null);
        Assertions.assertEquals("Familiar", telefono.getDescripcion());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        telefonoRepo.deleteById("3183980410");
        Telefono telefono = telefonoRepo.findById("3183980410").orElse(null);
        Assertions.assertNull(telefono);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Telefono> telefonos = telefonoRepo.findAll();
        telefonos.forEach (System.out:: println);
    }
}
