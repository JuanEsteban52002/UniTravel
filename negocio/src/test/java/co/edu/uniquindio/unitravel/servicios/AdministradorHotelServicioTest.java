package co.edu.uniquindio.unitravel.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
public class AdministradorHotelServicioTest {

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;


}
