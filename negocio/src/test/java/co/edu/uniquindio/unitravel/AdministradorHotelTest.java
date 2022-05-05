package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorHotelTest {

    @Autowired
    private AdministradorHotelRepo administradorHotelRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        AdministradorHotel administradorHotel = new AdministradorHotel("7777", "Admin 3", "admin3@gmail.com", "admin3");
        AdministradorHotel administradorHotelGuardado = administradorHotelRepo.save(administradorHotel);

        Assertions.assertNotNull(administradorHotelGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        AdministradorHotel admministradorHotel = administradorHotelRepo.findById("5555").orElse(null);
        admministradorHotel.setPassword("1111");
        administradorHotelRepo.save(admministradorHotel);
        administradorHotelRepo.findById("5555").orElse(null);
        Assertions.assertEquals("1111", admministradorHotel.getPassword());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        administradorHotelRepo.deleteById("5555");
        AdministradorHotel admministradorHotel = administradorHotelRepo.findById("5555").orElse(null);
        Assertions.assertNull(admministradorHotel);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<AdministradorHotel> administradorHotel = administradorHotelRepo.findAll();
        administradorHotel.forEach (System.out:: println);
    }
}
