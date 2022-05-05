package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Estado;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.repositorios.HabitacionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class HabitacionTest {

    @Autowired
    private HabitacionRepo habitacionRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Habitacion habitacion = new Habitacion(4, 50000, "4");
        Habitacion habitacionGuardada = habitacionRepo.save(habitacion);

        Assertions.assertNotNull(habitacionGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Habitacion habitacion = habitacionRepo.findById(1).orElse(null);
        habitacion.setCapacidad("4");
        habitacionRepo.save(habitacion);
        habitacionRepo.findById(1).orElse(null);
        Assertions.assertEquals("4", habitacion.getCapacidad());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        habitacionRepo.deleteById(1);
        Habitacion habitacion = habitacionRepo.findById(1).orElse(null);
        Assertions.assertNull(habitacion);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Habitacion> habitaciones = habitacionRepo.findAll();
        habitaciones.forEach (System.out:: println);
    }
}
