package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Carro;
import co.edu.uniquindio.unitravel.repositorios.CarroRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CarroTest {

    @Autowired
    private CarroRepo carroRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Carro carro = new Carro("QWE-123", 2019, 4, 1, 0, 1);
        Carro carroGuardado = carroRepo.save(carro);

        Assertions.assertNotNull(carroGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Carro carro = carroRepo.findById("ABC-123").orElse(null);
        carro.setEstado(0);
        carroRepo.save(carro);
        carroRepo.findById("ABC-123").orElse(null);
        Assertions.assertEquals(0, carro.getEstado());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        carroRepo.deleteById("ABC-123");
        Carro carro = carroRepo.findById("ABC-123").orElse(null);
        Assertions.assertNull(carro);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Carro> carros = carroRepo.findAll();
        carros.forEach (System.out:: println);
    }
}
