package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.repositorios.ComentarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ComentarioTest {

    @Autowired
    private ComentarioRepo comentarioRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Comentario comentario = new Comentario(3, "Me gusto la habitacion", 4);
        Comentario comentarioGuardado = comentarioRepo.save(comentario);

        Assertions.assertNotNull(comentarioGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Comentario comentario = comentarioRepo.findById("1").orElse(null);
        comentario.setComentario("Ah sisas");
        comentarioRepo.save(comentario);
        comentarioRepo.findById("1").orElse(null);
        Assertions.assertEquals("Ah sisas", comentario.getComentario());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {

        comentarioRepo.deleteById("1");
        Comentario comentario = comentarioRepo.findById("1").orElse(null);
        Assertions.assertNull(comentario);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Comentario> comentarios = comentarioRepo.findAll();
        comentarios.forEach (System.out:: println);
    }
}
