package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {


    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Administrador administrador = new Administrador("4578", "AdminUni 3", "adminUnitravel3@gmail.com","adminUni3");
        Administrador administradorGuardado = administradorRepo.save(administrador);

        Assertions.assertNotNull(administradorGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Administrador admministrador = administradorRepo.findById("8754").orElse(null);
        admministrador.setPassword("3333");
        administradorRepo.save(admministrador);
        administradorRepo.findById("8754").orElse(null);
        Assertions.assertEquals("3333", admministrador.getPassword());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        administradorRepo.deleteById("8754");
        Administrador admministrador = administradorRepo.findById("8754").orElse(null);
        Assertions.assertNull(admministrador);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Administrador> administradores = administradorRepo.findAll();
        administradores.forEach (System.out:: println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerReservasTotales() {

        List<Reserva> reservasTotales = administradorRepo.obtenerReservasTotales();
        reservasTotales.forEach(System.out:: println);
        Assertions.assertEquals(1, reservasTotales.size());
    }

}
