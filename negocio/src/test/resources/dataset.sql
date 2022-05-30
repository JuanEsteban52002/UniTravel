insert into ciudad values (1, "Armenia", "https://parlamentoandino.org/images/P-Fundacin-de-Armenia.jpg");
insert into ciudad values (2, "Bogota","https://upload.wikimedia.org/wikipedia/commons/2/24/Bogot%C3%A1_Colpatria_Night.jpg");
insert into ciudad values (3, "Santa Marta","https://cloudfront-us-east-1.images.arcpublishing.com/semana/W2USLWLWJ5FF3IJKDEHFYZSC5I.jpg" );
insert into ciudad values (4, "Pereira", "https://cdn.colombia.com/sdi/2022/01/13/turismo-pereira-top-25-987237.jpg");
insert into ciudad values (5, "Cartagena", "https://cdn.colombia.com/images/v2/turismo/sitios-turisticos/cartagena/ciudad-cartagena-800.jpg");
insert into ciudad values (6, "Barrancabermeja", "https://www.terminaldetransporte.gov.co/sites/default/files/2021-06/barrancabermeja.jpg");
insert into ciudad values (7, "Manizales", "https://i0.wp.com/www.bcnoticias.com.co/wp-content/uploads/2019/05/UJFRDKZTCK_20190520172114.jpeg?resize=600%2C399");

insert into cliente values ("1234", "juan@gmail.com", "Juan", "/N+FscXmawsnQJlmkyvHu5iKnpcWTcCaIBsAvoE/8lUpGnkhCmRLrWTk+7AWRicj", 1);
insert into cliente values ("5255", "pepe@gmail.com", "Pepe", "/N+FscXmawsnQJlmkyvHu5iKnpcWTcCaIBsAvoE/8lUpGnkhCmRLrWTk+7AWRicj", 2);
insert into cliente values ("4321", "mario@gmail.com", "Mario", "/N+FscXmawsnQJlmkyvHu5iKnpcWTcCaIBsAvoE/8lUpGnkhCmRLrWTk+7AWRicj", 3);
insert into cliente values ("7525", "juane.grandar@uqvirtual.edu.co", "Juan", "/N+FscXmawsnQJlmkyvHu5iKnpcWTcCaIBsAvoE/8lUpGnkhCmRLrWTk+7AWRicj", 4);

insert into administrador_hotel values ("5555", "admin1@gmail1.com", "Admin 1", "/N+FscXmawsnQJlmkyvHu5iKnpcWTcCaIBsAvoE/8lUpGnkhCmRLrWTk+7AWRicj");
insert into administrador_hotel values ("9999", "admin2@gmail1.com", "Admin 2", "/N+FscXmawsnQJlmkyvHu5iKnpcWTcCaIBsAvoE/8lUpGnkhCmRLrWTk+7AWRicj");

insert into administrador values ("8754", "adminUnitravel1@gmail.com", "AdminUni 1", "adminUni1");
insert into administrador values ("7852", "adminUnitravel2@gmail.com", "AdminUni 2", "adminUni2");

insert into hotel values (1, "Muy bonito", "Carrera 4", "Hotel 4", 5, "7458241", "9999", 2);
insert into hotel values (2, "Buena vista",  "Carrera 2", "Hotel 2", 4, "7489652", "9999", 2);
insert into hotel values (3 , "Muy cerca a el centro de la ciudad", "Carrera 3", "Hotel 3", 4, "7852584", "5555", 1);


insert into habitacion values (105001, "5", 57000, 1);
insert into habitacion values (206002, "4", 45000, 2);
insert into habitacion values (307001, "3", 35000, 1);
insert into habitacion values (308001, "3", 35000, 1);
insert into habitacion values (704001, "2", 25000, 1);

insert into cama values (1, "Sencilla", 105001);
insert into cama values (2, "Doble", 206002);
insert into cama values (3, "Triple", 307001);

insert into caracteristica values (1, "Hay camas", 1);
insert into caracteristica values (2, "No hay nada", 1);
insert into caracteristica values (3, "La cama es muy dura", 1);
insert into caracteristica values (4, "La cama es muy blanda", 1);
insert into caracteristica values (5, "Gimnasio", 0);
insert into caracteristica values (6, "Spa", 0);
insert into caracteristica values (7, "Se admiten mascotas", 0);
insert into caracteristica values (8, "Estacionamiento gratis", 0);

insert into caracteristica_hoteles values (5, 1);
insert into caracteristica_hoteles values (6, 1);
insert into caracteristica_hoteles values (5, 3);
insert into caracteristica_hoteles values (8, 2);
insert into caracteristica_hoteles values (6, 2);

insert into caracteristica_habitaciones values (3, 105001);
insert into caracteristica_habitaciones values (4, 206002);
insert into caracteristica_habitaciones values (1, 307001);
insert into caracteristica_habitaciones values (2, 308001);

insert into aeropuerto values ("A1", "Carrera 1","Aeropuerto el Eden", 1);
insert into aeropuerto values ("A2", "Carrera 2","Aeropuerto Internacional El Dorado ", 2);
insert into aeropuerto values ("A3", "Carrera 3","Internacional Simon Bolivar", 3);

insert into carro values ("ABC-123", 1, 4, 1, 2019, 250000, 1, "A1");
insert into carro values ("DEF-456", 1, 4, 1, 2019, 300000, 1, "A2");
insert into carro values ("GHI-789", 1, 6, 1, 2019, 150000, 1, "A3");

insert into hotel_fotos values (1, "https://memoflores.com/fotos-de-hoteles-05.jpg");
insert into hotel_fotos values (2, "https://imgcy.trivago.com/c_lfill,f_auto,g_faces,q_auto:good,w_756/mag/2021/08/25212949/lugares-turisticos-de-baja-california-sur-mexico-exterior.jpeg");
insert into hotel_fotos values (3, "https://assets.hiltonstatic.com/hilton-asset-cache/image/upload/t_MODx%20-%20Masthead/t_MODx%20-%20Masthead/v1626385058/Imagery/Property%20Photography/Hilton%20Full%20Service/C/CTGHIHH/Facade_Pool_Complex.jpg");

insert into habitacion_fotos values (704001,"https://www.cataloniahotels.com/es/blog/wp-content/uploads/2016/05/habitaci%C3%B3n-doble-catalonia-620x412.jpg");
insert into habitacion_fotos values (308001,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbTFnLLp0kA_5kNYAYTbyhvA1z1UcBuzkHCBO0NLj-KG4RPvwNo0EMQWjdn9hSQ-rLUic&usqp=CAU");
insert into habitacion_fotos values (307001,"https://dmdiluminacion.com/wp-content/uploads/hotel-lp-012-1200x498.jpg");
insert into habitacion_fotos values (206002,"https://s3.amazonaws.com/arc-wordpress-client-uploads/infobae-wp/wp-content/uploads/2019/05/20152451/Mandarin-Oriental-Hong-Kong-3.jpg");
insert into habitacion_fotos values (105001,"https://static.abc.es/Media/201504/27/hotel12--644x362.jpg");

insert into reserva values ("1", 1, 4, 1, "2022-05-15", "2022-05-13", "2022-05-12", 100000, "1234");
insert into reserva values ("2", 2, 4, 2, "2022-05-17", "2022-05-15", "2022-05-13", 100000, "5255");
insert into reserva values ("3", 3, 6, 1, "2022-05-20", "2022-05-18", "2022-05-17", 100000, "4321");

insert into vuelo values ("1", "Avianca", 0, 1, 2);
insert into vuelo values ("2", "Volaris", 0, 1, 3);
insert into vuelo values ("3", "Aero", 0, 2, 1);

insert into silla values ("1", 0, "A2", 100000, "1");
insert into silla values ("2", 0, "A3", 100000, "2");

insert into reserva_habitacion values ("1", 50000, 105001, "1");
insert into reserva_habitacion values ("2", 20000, 206002, "2");
insert into reserva_habitacion values ("3", 20000, 308001, "3");

insert into reserva_silla values ("1", 20000, "1", "1");
insert into reserva_silla values ("2", 20000, "2", "2");

insert into telefono values ("3183980410", "Personal", "1234");
insert into telefono values ("3163601741", "Trabajo", "5255");
insert into telefono values ("3189541695", "Casa", "4321");

insert into comentario values (1, 5, "Buen servicio", "2022-05-13", "1234", 1);
insert into comentario values (2, 4, "Muy buen servicio", "2022-05-15", "5255", 2);
insert into comentario values (3, 3, "Servicio regular", "2022-08-13", "1234", 1);
insert into comentario values (4, 2, "Malo servicio", "2022-08-15", "5255", 3);