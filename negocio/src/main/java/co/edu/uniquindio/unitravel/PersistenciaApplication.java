package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;


@SpringBootApplication
public class PersistenciaApplication {

    public static void main(String[] args) {
     SpringApplication.run(PersistenciaApplication.class, args);

    }
}
