insert into ciudad values (1, "Bogota");
insert into ciudad values (2, "Medellin");
insert into ciudad values (3, "Cali");
insert into ciudad values (4, "Cartagena");
insert into ciudad values (5, "Barranquilla");
insert into ciudad values (6, "Santa Marta");


insert into cliente values ("1234", "juan@gmail,com", "Juan", "5555", 1);
insert into cliente values ("5255", "pepe@gmail,com", "Pepe", "1234", 2);
insert into cliente values ("4321", "mario@gmail,com", "Mario", "1234", 3);
insert into cliente values ("7525", "juanS@gmail,com", "Juan", "5555", 4);



insert into administrador_hotel values ("5555", "admin1@gmail,com", "Admin 1", "admin1");
insert into administrador_hotel values ("9999", "admin2@gmail,com", "Admin 2", "admin2");


insert into hotel values (1, "Carrera 1", "Hotel 1", 5, "7458241", "5555", 1);
insert into hotel values (2, "Carrera 2", "Hotel 2", 4, "7489652", "9999", 2);
insert into hotel values (3, "Carrera 3", "Hotel 3", 4, "7852584", "5555", 1);



insert into administrador values ("8754", "adminUnitravel1@gmail,com", "AdminUni 1", "adminUni1");
insert into administrador values ("7852", "adminUnitravel2@gmail,com", "AdminUni 2", "adminUni2");


insert into habitacion values (1, "5", 57000, 1);
insert into habitacion values (2, "4", 45000, 1);
insert into habitacion values (3, "3", 35000, 1);
insert into habitacion values (4, "3", 35000, 1);


insert into cama values (1, "Sencilla", 1);
insert into cama values (2, "Doble", 2 );
insert into cama values (3, "Triple", 3 );


insert into caracteristica values (1, "Hay camas");
insert into caracteristica values (2, "No hay nada");
insert into caracteristica values (3, "La cama es muy dura");
insert into caracteristica values (4, "La cama es muy blanda");

insert into caracteristica_hoteles values (1, 1);
insert into caracteristica_hoteles values (2, 2);

insert into caracteristica_habitaciones values (3, 1);
insert into caracteristica_habitaciones values (4, 2);


insert into aeropuerto values ("A1", "Carrera 1","Aeropuerto Internacional El Dorado", 1);
insert into aeropuerto values ("A2", "Carrera 2","Aeropuerto 2", 2);
insert into aeropuerto values ("A3", "Carrera 3","Aeropuerto 3", 3);


insert into carro values ("ABC-123", 1, 4, 1, 2019, 250000, 1, "A1");
insert into carro values ("DEF-456", 1, 4, 1, 2019, 300000, 1, "A2");
insert into carro values ("GHI-789", 1, 6, 1, 2019, 150000, 1, "A3");


insert into foto values ("1", "foto1.jpg", 1, 1);
insert into foto values ("2", "foto2.jpg", 2, 1);
insert into foto values ("3", "foto3.jpg", 3, 1);

insert into reserva values ("1", 1, 4, 1, "2022-05-15", "2022-05-13", "2022-05-12", 100000, "1234");
insert into reserva values ("2", 2, 4, 2, "2022-05-17", "2022-05-15", "2022-05-13", 100000, "5255");


insert into reserva_habitacion values ("1", 50000, 1, "1");
insert into reserva_habitacion values ("2", 20000, 2, "2");


insert into vuelo values ("1", "Avianca", 0, 2, 1);
insert into vuelo values ("2", "Volaris", 0, 1, 3);


insert into silla values ("1", "A2", 100000, 1);
insert into silla values ("2", "A3", 100000, 2);


insert into reserva_silla values ("1", 20000, "1", "1");
insert into reserva_silla values ("2", 20000, "2", "2");


insert into telefono values ("3183980410", "Personal", "1234");
insert into telefono values ("3163601741", "Trabajo", "5255");
insert into telefono values ("3189541695", "Casa", "4321");


insert into comentario values ("1", 5, "Buen servicio", "2022-05-13", "1234", 1);
insert into comentario values ("2", 4, "Muy buen servicio", "2022-05-15", "5255", 2);
insert into comentario values ("3", 3, "Servicio regular", "2022-08-13", "1234", 1);
insert into comentario values ("4", 2, "Malo servicio", "2022-08-15", "5255", 3);