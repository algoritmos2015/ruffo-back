
START TRANSACTION;
# Actividades de una mascota
	insert into ruffo.actividadmascota (id, descripcion) 
	values (1, 'NORMAL');
	
	insert into ruffo.actividadmascota (id, descripcion) 
	values (2, 'EXTRAVIADA');
    
    insert into ruffo.actividadmascota (id, descripcion) 
	values (3, 'ENCONTRADA');
    
    insert into ruffo.actividadmascota (id, descripcion) 
	values (4, 'FALLECIDA');
	
# Partes de la mascota 
	insert into ruffo.partemascota (id, descripcion) 
	values (1, 'CABEZA');
	
	insert into ruffo.partemascota (id, descripcion) 
	values (2, 'PATAS');
    
    insert into ruffo.partemascota (id, descripcion) 
	values (3, 'COLA');
    
    insert into ruffo.partemascota (id, descripcion) 
	values (4, 'CUERPO');
	
	insert into ruffo.partemascota (id, descripcion) 
	values (5, 'CUELLO');

#  Caracteristicas	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (1, 'Ojos de diferente color', 1);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (2, 'Ciego', 1);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (3, 'Sin un ojo', 1);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (5, 'Orejas cortadas', 1);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (6, 'Oreja lastimada', 1);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (7, 'Cicatriz en hocico', 1);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (8, 'Cicatriz en cabeza', 1);    
	
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (9, 'Rengo', 2);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (10, 'Pata lastimada', 2);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (11, 'Sin alguna patita', 2);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (12, 'Sin cola', 3);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (13, 'Cola cortada', 3);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (14, 'Cola lastimada', 3);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (15, 'Cicatriz en el cuerpo', 4);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (16, 'Lastimadura en el cuerpo', 4);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (17, 'Recientemente operado', 4);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (18, 'Gorda/o', 4);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (19, 'Embarazada', 4);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (20, 'Collar amarillo', 5);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (21, 'Collar negro', 5);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (22, 'Collar blanco', 5);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (23, 'Collar marron', 5);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (24, 'Collar de cuero', 5);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (25, 'Collar de metal', 5);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (26, 'Collar rojo', 5);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (27, 'Collar azul', 5);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (28, 'Collar multicolor', 5);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (29, 'Lastimadura en el cuerpo', 4);
    
    insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (30, 'Pelo corto', 4);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (31, 'Pelo largo', 4);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (32, 'Pelo ondulado', 4);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (33, 'Pelo liso', 4);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (34, 'Sordo', 1);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (35, 'Collar rosado', 5);
	
	insert into ruffo.caracteristicaespecial (id, nombre, parteMascota_id) 
	values (36, 'Mancha en hocico', 1);
    
# Tipos de usuario
	insert into ruffo.tipoUsuario (id, descripcion) 
	values (1, 'NORMAL');
	
	insert into ruffo.tipoUsuario (id, descripcion) 
	values (2, 'VETERINARIO');

	#  Colores de mascotas
	insert into ruffo.color (id, tipoColor, descripcion) values (1, 'P', 'Blanco');
	insert into ruffo.color (id, tipoColor, descripcion) values (2, 'P', 'Negro');
	insert into ruffo.color (id, tipoColor, descripcion) values (3, 'P', 'Negro y blanco');	
	insert into ruffo.color (id, tipoColor, descripcion) values (4, 'P', 'Marrón');
	insert into ruffo.color (id, tipoColor, descripcion) values (5, 'P', 'Crema');
	insert into ruffo.color (id, tipoColor, descripcion) values (6, 'P', 'Gris');
	insert into ruffo.color (id, tipoColor, descripcion) values (7, 'P', 'Amarillo');
	insert into ruffo.color (id, tipoColor, descripcion) values (8, 'P', 'Gris y blanco');
	insert into ruffo.color (id, tipoColor, descripcion) values (9, 'P', 'Gris y negro');
	insert into ruffo.color (id, tipoColor, descripcion) values (10, 'P', 'Negro y marrón');
	insert into ruffo.color (id, tipoColor, descripcion) values (11, 'P', 'Amarillo y negro');
	insert into ruffo.color (id, tipoColor, descripcion) values (12, 'P', 'Crema y blanco');
	insert into ruffo.color (id, tipoColor, descripcion) values (13, 'P', 'Amarillo y blanco');
	insert into ruffo.color (id, tipoColor, descripcion) values (14, 'P', 'Negro, marrón y blanco');
	insert into ruffo.color (id, tipoColor, descripcion) values (15, 'P', 'Gris, negro y blanco');
	insert into ruffo.color (id, tipoColor, descripcion) values (16, 'P', 'Gris, blanco y amarillo');
	insert into ruffo.color (id, tipoColor, descripcion) values (17, 'P', 'Sin pelo');
	insert into ruffo.color (id, tipoColor, descripcion) values (18, 'P', 'Atigrado marron y negro');
	insert into ruffo.color (id, tipoColor, descripcion) values (19, 'P', 'Atigrado negro y gris');
	insert into ruffo.color (id, tipoColor, descripcion) values (20, 'P', 'Marrón y blanco');
	
	insert into ruffo.color (id, tipoColor, descripcion) values (21, 'S', 'Ninguno');
	insert into ruffo.color (id, tipoColor, descripcion) values (22, 'S', 'Blanco');
	insert into ruffo.color (id, tipoColor, descripcion) values (23, 'S', 'Negro');
	insert into ruffo.color (id, tipoColor, descripcion) values (24, 'S', 'Gris');
	insert into ruffo.color (id, tipoColor, descripcion) values (25, 'S', 'Marrón');
	insert into ruffo.color (id, tipoColor, descripcion) values (26, 'S', 'Amarillo');
	insert into ruffo.color (id, tipoColor, descripcion) values (27, 'S', 'Crema');
	insert into ruffo.color (id, tipoColor, descripcion) values (28, 'S', 'Otro');
	
	insert into ruffo.color (id, tipoColor, descripcion) values (29, 'P', 'Otro');

# Sexos de personas
	insert into ruffo.sexo (id, descripcion) 
	values (1, 'Masculino');
	
	insert into ruffo.sexo (id, descripcion) 
	values (2, 'Femenino');
    
    insert into ruffo.sexo (id, descripcion) 
	values (3, 'Otro');
    
    insert into ruffo.sexo (id, descripcion) 
	values (4, 'Prefiero no decirlo');

#  Sexos de mascotas
	insert into ruffo.sexomascota (id, descripcion) 
	values (1, 'Macho');
	
	insert into ruffo.sexomascota (id, descripcion) 
	values (2, 'Hembra');
    
    insert into ruffo.sexomascota (id, descripcion) 
	values (3, 'No logro distinguirlo');

#  Tamanios de mascotas
	insert into ruffo.tamanio (id, descripcion) 
	values (1, 'Chico');
	
	insert into ruffo.tamanio (id, descripcion) 
	values (2, 'Mediano');
    
    insert into ruffo.tamanio (id, descripcion) 
	values (3, 'Grande');
    
    insert into ruffo.tamanio (id, descripcion) 
	values (4, 'Otro');
	
	insert into ruffo.tamanio (id, descripcion) 
	values (5, 'Ninguno');

#  Tipos de mascotas
	insert into ruffo.tipoMascota (id, descripcion) values (1, 'Perro');
	insert into ruffo.tipoMascota (id, descripcion) values (2, 'Gato');
	insert into ruffo.tipoMascota (id, descripcion) values (3, 'Caballo');
	insert into ruffo.tipoMascota (id, descripcion) values (4, 'Otro');

#  Razas de mascotas
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (1, 1,'Alano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (2,1, 'Alaskan Malamute');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (3, 1,'American Staffordshire Terrier'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (4, 1,'American Water Spaniel'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (5, 1,'Antiguo Pastor Inglés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (6, 1,'Basset Azul de Gaseogne'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (7, 1,'Basset Hound');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (8, 1,'Basset leonado de Bretaña');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (9, 1,'Beagle');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (10, 1,'Bearded Collie');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (11, 1,'Bichón Maltés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (12, 1,'Bobtail');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (13, 1,'Border Collie');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (14, 1,'Boston Terrier');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (15, 1,'Boxer');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (16, 1,'Bull Terrier');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (17, 1,'Bulldog Americano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (18, 1,'Bulldog Francés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (19, 1,'Bulldog Inglés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (20, 1,'Caniche');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (21, 1,'Carlino');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (22, 1,'Chihuahua');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (23, 1,'Cimarrón');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (24, 1,'Cirneco del Etna');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (25, 1,'Chow Chow');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (26, 1,'Cocker Spaniel Americano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (27,1, 'Cocker Spaniel Inglés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (28,1, 'Dálmata');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (29, 1,'Dobermann'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (30, 1,'Dogo Alemán');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (31, 1,'Dogo Argentino');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (32, 1,'Dogo de Burdeos');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (33, 1,'Finlandés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (34, 1,'Fox Terrier de pelo liso');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (35, 1, 'Fox Terrier');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (36, 1, 'Foxhound Americano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (37, 1, 'Foxhound Inglés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (38, 1, 'Galgo Afgano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (39, 1, 'Gigante de los Pirineos');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (40, 1, 'Golden Retriever');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (41, 1, 'Gos d Atura');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (42, 1, 'Gran Danés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (43, 1, 'Husky Siberiano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (44, 1, 'Laika de Siberia Occidental');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (45, 1, 'Laika Ruso-europeo');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (46, 1, 'Labrador Retriever');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (47, 1, 'Mastín del Pirineo');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (48, 1, 'Mastin del Tibet');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (49, 1, 'Mastín Español');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (50, 1, 'Mastín Napolitano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (51, 1, 'Pastor Alemán');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (52, 1, 'Pastor Australiano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (53, 1, 'Pastor Belga');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (54, 1, 'Pastor de Brie');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (55, 1, 'Pastor de los Pirineos de Cara Rosa');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (56, 1, 'Pekinés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (57, 1, 'Perdiguero Chesapeake Bay');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (58, 1, 'Perdiguero de Drentse');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (59, 1, 'Perdiguero de Pelo lido');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (60, 1, 'Perdiguero de pelo rizado');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (61, 1, 'Perdiguero Portugués');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (62, 1, 'Pitbull');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (63, 1, 'Podenco Ibicenco');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (64, 1, 'Podenco Portugués');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (65, 1, 'Presa canario');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (66, 1, 'Presa Mallorquin');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (67, 1, 'Rottweiler'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (68, 1, 'Rough Collie');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (69, 1, 'Sabueso Español');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (70, 1, 'Sabueso Hélenico');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (71, 1, 'Sabueso Italiano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (72, 1, 'Sabueso Suizo');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (73, 1, 'Samoyedo');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (74, 1, 'San Bernardo'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (75, 1, 'Scottish Terrier');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (76, 1, 'Setter Irlandés'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (77, 1, 'Shar Pei'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (78, 1, 'Shiba Inu'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (79, 1, 'Siberian Husky');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (80, 1, 'Staffordshire Bull Terrier');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (81, 1, 'Teckel');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (82, 1, 'Terranova');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (83, 1, 'Terrier Australiano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (84, 1, 'Terrier Escocés'); 
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (85, 1, 'Terrier Irlandés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (86, 1, 'Terrier Japonés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (87, 1, 'Terrier Negro Ruso');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (88, 1, 'Terrier Norfolk');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (89, 1, 'Terrier Norwich');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (90, 1, 'Yorkshire Terrier');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (91, 1, 'Cruza o mixta');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (92, 1, 'Otra');
	
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (93, 2, 'Abisinio');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (94, 2, 'Alemán de pelo largo');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (95, 2, 'American curl');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (96, 2, 'American shorthair');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (97, 2, 'American wirehair');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (98, 2, 'Angora turco');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (99, 2, 'Australian mist');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (100, 2, 'Azul ruso');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (101, 2, 'Balinés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (102, 2, 'Bengalí');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (103, 2, 'Bogtail Japonés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (104, 2, 'Bosque de noruega');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (105, 2, 'Burmés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (106, 2, 'Burmilla');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (107, 2, 'Ceylon');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (108, 2, 'Chartreux');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (109, 2, 'Cornish rex');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (110, 2, 'Cymric');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (111, 2, 'Devon rex');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (112, 2, 'Don sphynx');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (113, 2, 'Europeo');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (114, 2, 'Exótico');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (115, 2, 'Gato bombay');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (116, 2, 'Gato brasileño');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (117, 2, 'Gato habana');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (118, 2, 'Korat');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (119, 2, 'LaPerm');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (120, 2, 'Manx');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (121, 2, 'Mau egipcio');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (122, 2, 'Munchkin');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (123, 2, 'Ocicat');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (124, 2, 'Ojos azules');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (125, 2, 'Oriental');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (126, 2, 'Oriental de pelo largo');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (127, 2, 'Persa');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (128, 2, 'Peterbald');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (129, 2, 'Pixiebob');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (130, 2, 'Sagrado de birmania');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (131, 2, 'Scottish fold');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (132, 2, 'Selkirk Rex');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (133, 2, 'Siamés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (134, 2, 'Siberiano');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (135, 2, 'Singapura');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (136, 2, 'Somalí');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (137, 2, 'Sphynx');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (138, 2, 'Tonkinés');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (139, 2, 'Van turco');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (140, 2, 'Cruza o mixto');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (141, 2, 'Otra');
	
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (142, 3, 'Otra');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (143, 4, 'Otra');
	
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (144, 1, 'Pug');
	insert into ruffo.raza (id, tipoMascota_id, descripcion) VALUES (145, 1, 'Cattle dog');
		
#  Paises
	INSERT INTO ruffo.pais VALUES(1, 'AF', 'Afganistán');
	INSERT INTO ruffo.pais VALUES(2, 'AX', 'Islas Gland');
	INSERT INTO ruffo.pais VALUES(3, 'AL', 'Albania');
	INSERT INTO ruffo.pais VALUES(4, 'DE', 'Alemania');
	INSERT INTO ruffo.pais VALUES(5, 'AD', 'Andorra');
	INSERT INTO ruffo.pais VALUES(6, 'AO', 'Angola');
	INSERT INTO ruffo.pais VALUES(7, 'AI', 'Anguilla');
	INSERT INTO ruffo.pais VALUES(8, 'AQ', 'Antártida');
	INSERT INTO ruffo.pais VALUES(9, 'AG', 'Antigua y Barbuda');
	INSERT INTO ruffo.pais VALUES(10, 'AN', 'Antillas Holandesas');
	INSERT INTO ruffo.pais VALUES(11, 'SA', 'Arabia Saudí');
	INSERT INTO ruffo.pais VALUES(12, 'DZ', 'Argelia');
	INSERT INTO ruffo.pais VALUES(13, 'AR', 'Argentina');
	INSERT INTO ruffo.pais VALUES(14, 'AM', 'Armenia');
	INSERT INTO ruffo.pais VALUES(15, 'AW', 'Aruba');
	INSERT INTO ruffo.pais VALUES(16, 'AU', 'Australia');
	INSERT INTO ruffo.pais VALUES(17, 'AT', 'Austria');
	INSERT INTO ruffo.pais VALUES(18, 'AZ', 'Azerbaiyán');
	INSERT INTO ruffo.pais VALUES(19, 'BS', 'Bahamas');
	INSERT INTO ruffo.pais VALUES(20, 'BH', 'Bahréin');
	INSERT INTO ruffo.pais VALUES(21, 'BD', 'Bangladesh');
	INSERT INTO ruffo.pais VALUES(22, 'BB', 'Barbados');
	INSERT INTO ruffo.pais VALUES(23, 'BY', 'Bielorrusia');
	INSERT INTO ruffo.pais VALUES(24, 'BE', 'Bélgica');
	INSERT INTO ruffo.pais VALUES(25, 'BZ', 'Belice');
	INSERT INTO ruffo.pais VALUES(26, 'BJ', 'Benin');
	INSERT INTO ruffo.pais VALUES(27, 'BM', 'Bermudas');
	INSERT INTO ruffo.pais VALUES(28, 'BT', 'Bhután');
	INSERT INTO ruffo.pais VALUES(29, 'BO', 'Bolivia');
	INSERT INTO ruffo.pais VALUES(30, 'BA', 'Bosnia y Herzegovina');
	INSERT INTO ruffo.pais VALUES(31, 'BW', 'Botsuana');
	INSERT INTO ruffo.pais VALUES(32, 'BV', 'Isla Bouvet');
	INSERT INTO ruffo.pais VALUES(33, 'BR', 'Brasil');
	INSERT INTO ruffo.pais VALUES(34, 'BN', 'Brunéi');
	INSERT INTO ruffo.pais VALUES(35, 'BG', 'Bulgaria');
	INSERT INTO ruffo.pais VALUES(36, 'BF', 'Burkina Faso');
	INSERT INTO ruffo.pais VALUES(37, 'BI', 'Burundi');
	INSERT INTO ruffo.pais VALUES(38, 'CV', 'Cabo Verde');
	INSERT INTO ruffo.pais VALUES(39, 'KY', 'Islas Caimán');
	INSERT INTO ruffo.pais VALUES(40, 'KH', 'Camboya');
	INSERT INTO ruffo.pais VALUES(41, 'CM', 'Camerún');
	INSERT INTO ruffo.pais VALUES(42, 'CA', 'Canadá');
	INSERT INTO ruffo.pais VALUES(43, 'CF', 'República Centroafricana');
	INSERT INTO ruffo.pais VALUES(44, 'TD', 'Chad');
	INSERT INTO ruffo.pais VALUES(45, 'CZ', 'República Checa');
	INSERT INTO ruffo.pais VALUES(46, 'CL', 'Chile');
	INSERT INTO ruffo.pais VALUES(47, 'CN', 'China');
	INSERT INTO ruffo.pais VALUES(48, 'CY', 'Chipre');
	INSERT INTO ruffo.pais VALUES(49, 'CX', 'Isla de Navidad');
	INSERT INTO ruffo.pais VALUES(50, 'VA', 'Ciudad del Vaticano');
	INSERT INTO ruffo.pais VALUES(51, 'CC', 'Islas Cocos');
	INSERT INTO ruffo.pais VALUES(52, 'CO', 'Colombia');
	INSERT INTO ruffo.pais VALUES(53, 'KM', 'Comoras');
	INSERT INTO ruffo.pais VALUES(54, 'CD', 'República Democrática del Congo');
	INSERT INTO ruffo.pais VALUES(55, 'CG', 'Congo');
	INSERT INTO ruffo.pais VALUES(56, 'CK', 'Islas Cook');
	INSERT INTO ruffo.pais VALUES(57, 'KP', 'Corea del Norte');
	INSERT INTO ruffo.pais VALUES(58, 'KR', 'Corea del Sur');
	INSERT INTO ruffo.pais VALUES(59, 'CI', 'Costa de Marfil');
	INSERT INTO ruffo.pais VALUES(60, 'CR', 'Costa Rica');
	INSERT INTO ruffo.pais VALUES(61, 'HR', 'Croacia');
	INSERT INTO ruffo.pais VALUES(62, 'CU', 'Cuba');
	INSERT INTO ruffo.pais VALUES(63, 'DK', 'Dinamarca');
	INSERT INTO ruffo.pais VALUES(64, 'DM', 'Dominica');
	INSERT INTO ruffo.pais VALUES(65, 'DO', 'República Dominicana');
	INSERT INTO ruffo.pais VALUES(66, 'EC', 'Ecuador');
	INSERT INTO ruffo.pais VALUES(67, 'EG', 'Egipto');
	INSERT INTO ruffo.pais VALUES(68, 'SV', 'El Salvador');
	INSERT INTO ruffo.pais VALUES(69, 'AE', 'Emiratos Árabes Unidos');
	INSERT INTO ruffo.pais VALUES(70, 'ER', 'Eritrea');
	INSERT INTO ruffo.pais VALUES(71, 'SK', 'Eslovaquia');
	INSERT INTO ruffo.pais VALUES(72, 'SI', 'Eslovenia');
	INSERT INTO ruffo.pais VALUES(73, 'ES', 'España');
	INSERT INTO ruffo.pais VALUES(74, 'UM', 'Islas ultramarinas de Estados Unidos');
	INSERT INTO ruffo.pais VALUES(75, 'US', 'Estados Unidos');
	INSERT INTO ruffo.pais VALUES(76, 'EE', 'Estonia');
	INSERT INTO ruffo.pais VALUES(77, 'ET', 'Etiopía');
	INSERT INTO ruffo.pais VALUES(78, 'FO', 'Islas Feroe');
	INSERT INTO ruffo.pais VALUES(79, 'PH', 'Filipinas');
	INSERT INTO ruffo.pais VALUES(80, 'FI', 'Finlandia');
	INSERT INTO ruffo.pais VALUES(81, 'FJ', 'Fiyi');
	INSERT INTO ruffo.pais VALUES(82, 'FR', 'Francia');
	INSERT INTO ruffo.pais VALUES(83, 'GA', 'Gabón');
	INSERT INTO ruffo.pais VALUES(84, 'GM', 'Gambia');
	INSERT INTO ruffo.pais VALUES(85, 'GE', 'Georgia');
	INSERT INTO ruffo.pais VALUES(86, 'GS', 'Islas Georgias del Sur y Sandwich del Sur');
	INSERT INTO ruffo.pais VALUES(87, 'GH', 'Ghana');
	INSERT INTO ruffo.pais VALUES(88, 'GI', 'Gibraltar');
	INSERT INTO ruffo.pais VALUES(89, 'GD', 'Granada');
	INSERT INTO ruffo.pais VALUES(90, 'GR', 'Grecia');
	INSERT INTO ruffo.pais VALUES(91, 'GL', 'Groenlandia');
	INSERT INTO ruffo.pais VALUES(92, 'GP', 'Guadalupe');
	INSERT INTO ruffo.pais VALUES(93, 'GU', 'Guam');
	INSERT INTO ruffo.pais VALUES(94, 'GT', 'Guatemala');
	INSERT INTO ruffo.pais VALUES(95, 'GF', 'Guayana Francesa');
	INSERT INTO ruffo.pais VALUES(96, 'GN', 'Guinea');
	INSERT INTO ruffo.pais VALUES(97, 'GQ', 'Guinea Ecuatorial');
	INSERT INTO ruffo.pais VALUES(98, 'GW', 'Guinea-Bissau');
	INSERT INTO ruffo.pais VALUES(99, 'GY', 'Guyana');
	INSERT INTO ruffo.pais VALUES(100, 'HT', 'Haití');
	INSERT INTO ruffo.pais VALUES(101, 'HM', 'Islas Heard y McDonald');
	INSERT INTO ruffo.pais VALUES(102, 'HN', 'Honduras');
	INSERT INTO ruffo.pais VALUES(103, 'HK', 'Hong Kong');
	INSERT INTO ruffo.pais VALUES(104, 'HU', 'Hungría');
	INSERT INTO ruffo.pais VALUES(105, 'IN', 'India');
	INSERT INTO ruffo.pais VALUES(106, 'ID', 'Indonesia');
	INSERT INTO ruffo.pais VALUES(107, 'IR', 'Irán');
	INSERT INTO ruffo.pais VALUES(108, 'IQ', 'Iraq');
	INSERT INTO ruffo.pais VALUES(109, 'IE', 'Irlanda');
	INSERT INTO ruffo.pais VALUES(110, 'IS', 'Islandia');
	INSERT INTO ruffo.pais VALUES(111, 'IL', 'Israel');
	INSERT INTO ruffo.pais VALUES(112, 'IT', 'Italia');
	INSERT INTO ruffo.pais VALUES(113, 'JM', 'Jamaica');
	INSERT INTO ruffo.pais VALUES(114, 'JP', 'Japón');
	INSERT INTO ruffo.pais VALUES(115, 'JO', 'Jordania');
	INSERT INTO ruffo.pais VALUES(116, 'KZ', 'Kazajstán');
	INSERT INTO ruffo.pais VALUES(117, 'KE', 'Kenia');
	INSERT INTO ruffo.pais VALUES(118, 'KG', 'Kirguistán');
	INSERT INTO ruffo.pais VALUES(119, 'KI', 'Kiribati');
	INSERT INTO ruffo.pais VALUES(120, 'KW', 'Kuwait');
	INSERT INTO ruffo.pais VALUES(121, 'LA', 'Laos');
	INSERT INTO ruffo.pais VALUES(122, 'LS', 'Lesotho');
	INSERT INTO ruffo.pais VALUES(123, 'LV', 'Letonia');
	INSERT INTO ruffo.pais VALUES(124, 'LB', 'Líbano');
	INSERT INTO ruffo.pais VALUES(125, 'LR', 'Liberia');
	INSERT INTO ruffo.pais VALUES(126, 'LY', 'Libia');
	INSERT INTO ruffo.pais VALUES(127, 'LI', 'Liechtenstein');
	INSERT INTO ruffo.pais VALUES(128, 'LT', 'Lituania');
	INSERT INTO ruffo.pais VALUES(129, 'LU', 'Luxemburgo');
	INSERT INTO ruffo.pais VALUES(130, 'MO', 'Macao');
	INSERT INTO ruffo.pais VALUES(131, 'MK', 'ARY Macedonia');
	INSERT INTO ruffo.pais VALUES(132, 'MG', 'Madagascar');
	INSERT INTO ruffo.pais VALUES(133, 'MY', 'Malasia');
	INSERT INTO ruffo.pais VALUES(134, 'MW', 'Malawi');
	INSERT INTO ruffo.pais VALUES(135, 'MV', 'Maldivas');
	INSERT INTO ruffo.pais VALUES(136, 'ML', 'Malí');
	INSERT INTO ruffo.pais VALUES(137, 'MT', 'Malta');
	INSERT INTO ruffo.pais VALUES(138, 'FK', 'Islas Malvinas');
	INSERT INTO ruffo.pais VALUES(139, 'MP', 'Islas Marianas del Norte');
	INSERT INTO ruffo.pais VALUES(140, 'MA', 'Marruecos');
	INSERT INTO ruffo.pais VALUES(141, 'MH', 'Islas Marshall');
	INSERT INTO ruffo.pais VALUES(142, 'MQ', 'Martinica');
	INSERT INTO ruffo.pais VALUES(143, 'MU', 'Mauricio');
	INSERT INTO ruffo.pais VALUES(144, 'MR', 'Mauritania');
	INSERT INTO ruffo.pais VALUES(145, 'YT', 'Mayotte');
	INSERT INTO ruffo.pais VALUES(146, 'MX', 'México');
	INSERT INTO ruffo.pais VALUES(147, 'FM', 'Micronesia');
	INSERT INTO ruffo.pais VALUES(148, 'MD', 'Moldavia');
	INSERT INTO ruffo.pais VALUES(149, 'MC', 'Mónaco');
	INSERT INTO ruffo.pais VALUES(150, 'MN', 'Mongolia');
	INSERT INTO ruffo.pais VALUES(151, 'MS', 'Montserrat');
	INSERT INTO ruffo.pais VALUES(152, 'MZ', 'Mozambique');
	INSERT INTO ruffo.pais VALUES(153, 'MM', 'Myanmar');
	INSERT INTO ruffo.pais VALUES(154, 'NA', 'Namibia');
	INSERT INTO ruffo.pais VALUES(155, 'NR', 'Nauru');
	INSERT INTO ruffo.pais VALUES(156, 'NP', 'Nepal');
	INSERT INTO ruffo.pais VALUES(157, 'NI', 'Nicaragua');
	INSERT INTO ruffo.pais VALUES(158, 'NE', 'Níger');
	INSERT INTO ruffo.pais VALUES(159, 'NG', 'Nigeria');
	INSERT INTO ruffo.pais VALUES(160, 'NU', 'Niue');
	INSERT INTO ruffo.pais VALUES(161, 'NF', 'Isla Norfolk');
	INSERT INTO ruffo.pais VALUES(162, 'NO', 'Noruega');
	INSERT INTO ruffo.pais VALUES(163, 'NC', 'Nueva Caledonia');
	INSERT INTO ruffo.pais VALUES(164, 'NZ', 'Nueva Zelanda');
	INSERT INTO ruffo.pais VALUES(165, 'OM', 'Omán');
	INSERT INTO ruffo.pais VALUES(166, 'NL', 'Países Bajos');
	INSERT INTO ruffo.pais VALUES(167, 'PK', 'Pakistán');
	INSERT INTO ruffo.pais VALUES(168, 'PW', 'Palau');
	INSERT INTO ruffo.pais VALUES(169, 'PS', 'Palestina');
	INSERT INTO ruffo.pais VALUES(170, 'PA', 'Panamá');
	INSERT INTO ruffo.pais VALUES(171, 'PG', 'Papúa Nueva Guinea');
	INSERT INTO ruffo.pais VALUES(172, 'PY', 'Paraguay');
	INSERT INTO ruffo.pais VALUES(173, 'PE', 'Perú');
	INSERT INTO ruffo.pais VALUES(174, 'PN', 'Islas Pitcairn');
	INSERT INTO ruffo.pais VALUES(175, 'PF', 'Polinesia Francesa');
	INSERT INTO ruffo.pais VALUES(176, 'PL', 'Polonia');
	INSERT INTO ruffo.pais VALUES(177, 'PT', 'Portugal');
	INSERT INTO ruffo.pais VALUES(178, 'PR', 'Puerto Rico');
	INSERT INTO ruffo.pais VALUES(179, 'QA', 'Qatar');
	INSERT INTO ruffo.pais VALUES(180, 'GB', 'Reino Unido');
	INSERT INTO ruffo.pais VALUES(181, 'RE', 'Reunión');
	INSERT INTO ruffo.pais VALUES(182, 'RW', 'Ruanda');
	INSERT INTO ruffo.pais VALUES(183, 'RO', 'Rumania');
	INSERT INTO ruffo.pais VALUES(184, 'RU', 'Rusia');
	INSERT INTO ruffo.pais VALUES(185, 'EH', 'Sahara Occidental');
	INSERT INTO ruffo.pais VALUES(186, 'SB', 'Islas Salomón');
	INSERT INTO ruffo.pais VALUES(187, 'WS', 'Samoa');
	INSERT INTO ruffo.pais VALUES(188, 'AS', 'Samoa Americana');
	INSERT INTO ruffo.pais VALUES(189, 'KN', 'San Cristóbal y Nevis');
	INSERT INTO ruffo.pais VALUES(190, 'SM', 'San Marino');
	INSERT INTO ruffo.pais VALUES(191, 'PM', 'San Pedro y Miquelón');
	INSERT INTO ruffo.pais VALUES(192, 'VC', 'San Vicente y las Granadinas');
	INSERT INTO ruffo.pais VALUES(193, 'SH', 'Santa Helena');
	INSERT INTO ruffo.pais VALUES(194, 'LC', 'Santa Lucía');
	INSERT INTO ruffo.pais VALUES(195, 'ST', 'Santo Tomé y Príncipe');
	INSERT INTO ruffo.pais VALUES(196, 'SN', 'Senegal');
	INSERT INTO ruffo.pais VALUES(197, 'CS', 'Serbia y Montenegro');
	INSERT INTO ruffo.pais VALUES(198, 'SC', 'Seychelles');
	INSERT INTO ruffo.pais VALUES(199, 'SL', 'Sierra Leona');
	INSERT INTO ruffo.pais VALUES(200, 'SG', 'Singapur');
	INSERT INTO ruffo.pais VALUES(201, 'SY', 'Siria');
	INSERT INTO ruffo.pais VALUES(202, 'SO', 'Somalia');
	INSERT INTO ruffo.pais VALUES(203, 'LK', 'Sri Lanka');
	INSERT INTO ruffo.pais VALUES(204, 'SZ', 'Suazilandia');
	INSERT INTO ruffo.pais VALUES(205, 'ZA', 'Sudáfrica');
	INSERT INTO ruffo.pais VALUES(206, 'SD', 'Sudán');
	INSERT INTO ruffo.pais VALUES(207, 'SE', 'Suecia');
	INSERT INTO ruffo.pais VALUES(208, 'CH', 'Suiza');
	INSERT INTO ruffo.pais VALUES(209, 'SR', 'Surinam');
	INSERT INTO ruffo.pais VALUES(210, 'SJ', 'Svalbard y Jan Mayen');
	INSERT INTO ruffo.pais VALUES(211, 'TH', 'Tailandia');
	INSERT INTO ruffo.pais VALUES(212, 'TW', 'Taiwán');
	INSERT INTO ruffo.pais VALUES(213, 'TZ', 'Tanzania');
	INSERT INTO ruffo.pais VALUES(214, 'TJ', 'Tayikistán');
	INSERT INTO ruffo.pais VALUES(215, 'IO', 'Territorio Británico del Océano Índico');
	INSERT INTO ruffo.pais VALUES(216, 'TF', 'Territorios Australes Franceses');
	INSERT INTO ruffo.pais VALUES(217, 'TL', 'Timor Oriental');
	INSERT INTO ruffo.pais VALUES(218, 'TG', 'Togo');
	INSERT INTO ruffo.pais VALUES(219, 'TK', 'Tokelau');
	INSERT INTO ruffo.pais VALUES(220, 'TO', 'Tonga');
	INSERT INTO ruffo.pais VALUES(221, 'TT', 'Trinidad y Tobago');
	INSERT INTO ruffo.pais VALUES(222, 'TN', 'Túnez');
	INSERT INTO ruffo.pais VALUES(223, 'TC', 'Islas Turcas y Caicos');
	INSERT INTO ruffo.pais VALUES(224, 'TM', 'Turkmenistán');
	INSERT INTO ruffo.pais VALUES(225, 'TR', 'Turquía');
	INSERT INTO ruffo.pais VALUES(226, 'TV', 'Tuvalu');
	INSERT INTO ruffo.pais VALUES(227, 'UA', 'Ucrania');
	INSERT INTO ruffo.pais VALUES(228, 'UG', 'Uganda');
	INSERT INTO ruffo.pais VALUES(229, 'UY', 'Uruguay');
	INSERT INTO ruffo.pais VALUES(230, 'UZ', 'Uzbekistán');
	INSERT INTO ruffo.pais VALUES(231, 'VU', 'Vanuatu');
	INSERT INTO ruffo.pais VALUES(232, 'VE', 'Venezuela');
	INSERT INTO ruffo.pais VALUES(233, 'VN', 'Vietnam');
	INSERT INTO ruffo.pais VALUES(234, 'VG', 'Islas Vírgenes Británicas');
	INSERT INTO ruffo.pais VALUES(235, 'VI', 'Islas Vírgenes de los Estados Unidos');
	INSERT INTO ruffo.pais VALUES(236, 'WF', 'Wallis y Futuna');
	INSERT INTO ruffo.pais VALUES(237, 'YE', 'Yemen');
	INSERT INTO ruffo.pais VALUES(238, 'DJ', 'Yibuti');
	INSERT INTO ruffo.pais VALUES(239, 'ZM', 'Zambia');
	INSERT INTO ruffo.pais VALUES(240, 'ZW', 'Zimbabue');

#  Departamentos de Uruguay
	insert into ruffo.departamento (id, descripcion, pais_id) values (1, 'Artigas', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (2, 'Canelones', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (3, 'Cerro Largo', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (4, 'Colonia', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (5, 'Durazno', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (6, 'Flores', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (7, 'Florida', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (8, 'Lavalleja', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (9, 'Maldonado', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (10, 'Montevideo', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (11, 'Paysandu', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (12, 'Rio Negro', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (13, 'Rivera', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (14, 'Rocha', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (15, 'Salto', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (16, 'San Jose', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (17, 'Soriano', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (18, 'Tacuarembo', (select id from ruffo.pais where nombre = 'Uruguay'));
	insert into ruffo.departamento (id, descripcion, pais_id) values (19, 'Treinta Y Tres', (select id from ruffo.pais where nombre = 'Uruguay'));


#  Localidades de Uruguay
	insert into ruffo.localidad (id, departamento_id, descripcion) values (1, 1, 'Artigas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (2, 1, 'Baltazar Brum'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (3, 1, 'Bella Union'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (4, 1, 'Bernabe Rivera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (5, 1, 'Campamento'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (6, 1, 'Coronado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (7, 1, 'Cuareim'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (8, 1, 'Diego Lamas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (9, 1, 'Franquia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (10, 1, 'Javier De Viana'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (11, 1, 'Las Piedras'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (12, 1, 'Montes Quintela'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (13, 1, 'Pintadito'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (14, 1, 'Port. De Hierro Y Campodonico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (15, 1, 'Sequeira'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (16, 1, 'Tomas Gomensoro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (17, 1, 'Topador'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (18, 2, 'Aeropuerto Nacional De Carrasc'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (19, 2, 'Aguas Corrientes'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (20, 2, 'Araminda'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (21, 2, 'Atlantida'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (22, 2, 'Barra De Carrasco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (23, 2, 'Barros Blancos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (24, 2, 'Bello Horizonte'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (25, 2, 'Biarritz'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (26, 2, 'Bolivar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (27, 2, 'Camino A La Cadena'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (28, 2, 'Canelon Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (29, 2, 'Canelon Grande'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (30, 2, 'Canelones'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (31, 2, 'Cañada De Cardozo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (32, 2, 'Capilla De Celia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (33, 2, 'Capitan J. A. Artigas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (34, 2, 'Carrasco Del Sauce'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (35, 2, 'Castellanos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (36, 2, 'Cerrillos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (37, 2, 'Cerrillos Al Sur'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (38, 2, 'Colinas De Solymar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (39, 2, 'Colonia Nicolich'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (40, 2, 'Costa Azul'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (41, 2, 'Costa Y Guillamon'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (42, 2, 'Cruz De Los Caminos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (43, 2, 'Cuchilla Alta'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (44, 2, 'Cueva Del Tigre'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (45, 2, 'Dr. Francisco Soca'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (46, 2, 'Echevarria'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (47, 2, 'El Bosque'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (48, 2, 'El Colorado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (49, 2, 'El Dorado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (50, 2, 'El Galeon'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (51, 2, 'El Pinar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (52, 2, 'Empalme Olmos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (53, 2, 'Empalme Sauce'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (54, 2, 'Estacion Margat'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (55, 2, 'Estacion Migues'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (56, 2, 'Estacion Pedrera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (57, 2, 'Estacion Tapia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (58, 2, 'Estanque De Pando'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (59, 2, 'Fatima'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (60, 2, 'Fortin De Santa Rosa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (61, 2, 'Fracc.Cam.Del Andaluz Y R.84'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (62, 2, 'Fraccionam. Cno. Maldonado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (63, 2, 'Fraccionamiento Progreso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (64, 2, 'Fraccionamiento Sobre Ruta 74'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (65, 2, 'Guazuvira'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (66, 2, 'Jardines De Pando'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (67, 2, 'Jaureguiberry'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (68, 2, 'Neptunia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (69, 2, 'Palmitas De Toledo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (70, 2, 'Pando'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (71, 2, 'Parada Cabrera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (72, 2, 'Parador Tajes'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (73, 2, 'Parque Del Plata'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (74, 2, 'Parque Miramar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (75, 2, 'Parque Solymar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (76, 2, 'Parque De Carrasco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (77, 2, 'Paso De La Cadena'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (78, 2, 'Paso Palomeque'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (79, 2, 'Piedra Del Toro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (80, 2, 'Piedras De Afilar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (81, 2, 'Pinamar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (82, 2, 'Pinepark'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (83, 2, 'Pinares De Solymar Norte'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (84, 2, 'Progreso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (85, 2, 'Pueblo Capitan Artigas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (86, 2, 'Puntas De Pantanoso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (87, 2, 'Rincon De Pando'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (88, 2, 'Rincon Del Colorado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (89, 2, 'Salinas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (90, 2, 'San Antonio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (91, 2, 'San Bautista'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (92, 2, 'San Bernardo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (93, 2, 'San Jacinto'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (94, 2, 'San Jose De Carrasco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (95, 2, 'San Luis'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (96, 2, 'San Pedro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (97, 2, 'San Ramon'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (98, 2, 'Santa Ana'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (99, 2, 'Santa Lucia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (100, 2, 'Santa Lucia Del Este'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (101, 2, 'Santa Rosa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (102, 2, 'Santos Lugares'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (103, 2, 'Sauce'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (104, 2, 'Sauce Del Solis'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (105, 2, 'Seis Hermanos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (106, 2, 'Shangrila'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (107, 2, 'Soca'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (108, 2, 'Solis'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (109, 2, 'Solymar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (110, 2, 'Solymar Norte'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (111, 2, 'Tala'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (112, 2, 'Joaquin Suarez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (113, 2, 'Juanico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (114, 2, 'La Floresta'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (115, 2, 'La Palmita'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (116, 2, 'La Paz'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (117, 2, 'La Querencia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (118, 2, 'La Tuna'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (119, 2, 'Lagomar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (120, 2, 'Lagomar Norte'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (121, 2, 'Las Brujas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (122, 2, 'Las Piedras'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (123, 2, 'Las Toscas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (124, 2, 'Las Vegas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (125, 2, 'Lomas De Solymar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (126, 2, 'Lomas De Toledo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (127, 2, 'Los Aromos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (128, 2, 'Los Titanes'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (129, 2, 'Marindia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (130, 2, 'Medanos De Solymar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (131, 2, 'Melilla'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (132, 2, 'Migues'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (133, 2, 'Montes'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (134, 2, 'Montes De Solymar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (135, 2, 'Tapia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (136, 2, 'Toledo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (137, 2, 'Toledo Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (138, 2, 'Totoral Del Sauce'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (139, 2, 'Tropas Viejas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (140, 2, '"Villa ""el Tato"""'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (141, 2, 'Villa Aeroparque'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (142, 2, 'Villa Arejo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (143, 2, 'Villa Argentina'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (144, 2, 'Villa Crespo Y San Andres'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (145, 2, 'Villa De Vasallo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (146, 2, 'Villa Encantada'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (147, 2, 'Villa Felicidad'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (148, 2, 'Villa Manuela'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (149, 2, 'Villa Olmo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (150, 2, 'Villa Paz Sa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (151, 2, 'Villa Porvenir'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (152, 2, 'Villa Prado De Toledo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (153, 2, 'Villa San Francisco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (154, 2, 'Villa San Jose'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (155, 2, 'Villanueva'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (156, 2, 'Vista Linda'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (157, 2, 'Monaco De Carrasco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (158, 2, 'Parque Roosvelt'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (159, 2, 'Sierra Del Mar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (160, 3, 'Acegua'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (161, 3, 'Uruguay'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (162, 3, 'Aguirre'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (163, 3, 'Arbolito'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (164, 3, 'Arevalo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (165, 3, 'Arrozal Casarone'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (166, 3, 'Bañado De Medina'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (167, 3, 'Bañado De Saturnino'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (168, 3, 'Barrio De Vinchuca'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (169, 3, 'Buena Vista'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (170, 3, 'Calera De Recalde'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (171, 3, 'Campamento'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (172, 3, 'Cañas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (173, 3, 'Cañitas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (174, 3, 'Centurion'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (175, 3, 'Cerro De Las Cuentas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (176, 3, 'Coimbra'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (177, 3, 'Costa De Yaguaron'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (178, 3, 'Cruz De Piedra'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (179, 3, 'Cuchilla De Melo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (180, 3, 'Cuchilla Del Carmen'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (181, 3, 'Cuchilla Peralta'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (182, 3, 'Esperanza'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (183, 3, 'Frayle Muerto'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (184, 3, 'Ganen'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (185, 3, 'Garao'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (186, 3, 'Getulio Vargas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (187, 3, 'Guazunambi'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (188, 3, 'Hipodromo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (189, 3, 'Isidoro Noblia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (191, 3, 'La Gloria'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (192, 14,' La Pedrera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (193, 3, 'Lago Merin'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (194, 3, 'Laguna Del Junco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (195, 3, 'Las Limas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (196, 3, 'Mederos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (197, 3, 'Melo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (198, 3, 'Mengrullo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (199, 3, 'Nando'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (200, 3, 'Olimar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (202, 3, 'Pajaro Azul'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (203, 3, 'Paso De Almada'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (204, 3, 'Paso De Las Tropas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (205, 3, 'Paso Pereira'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (206, 3, 'Picada De Salome'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (207, 3, 'Piedra Alta'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (208, 3, 'Placido Rosas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (209, 3, 'Pueblo Arevalo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (210, 3, 'Puntas De Minas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (211, 3, 'Puntas De Tacuari'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (212, 3, 'Quebracho'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (213, 3, 'Raab Arrocera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (214, 3, 'Ramon Trigo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (215, 3, 'Rincon De Contreras'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (216, 3, 'Rincon De Montana'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (217, 3, 'Rincon De Paiva'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (218, 3, 'Rio Branco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (219, 3, 'Rodriguez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (220, 3, 'San Servando'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (221, 3, 'Sanchez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (222, 3, 'Santa Clara'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (223, 3, 'Sarandi De Acegua'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (224, 3, 'Soto Goro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (225, 3, 'Toledo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (226, 3, 'Tres Boliches'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (227, 3, 'Tres Islas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (228, 3, 'Tupambae'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (229, 4, 'Miguelete De Conchillas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (230, 4, 'Minas De Talco De Narancio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (231, 4, 'Nueva Helvecia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (232, 4, 'Nueva Palmira'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (233, 4, 'Ombues De Lavalle'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (234, 4, 'Paraje Minuano'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (235, 4, 'Paso Antolin'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (236, 4, 'Pastoreo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (237, 4, 'Piedra De Los Indios'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (238, 4, 'Playa Azul'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (239, 4, 'Playa Britopolis'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (240, 4, 'Playa Fomento'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (241, 4, 'Playa Paran'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (242, 4, 'Polanco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (243, 4, 'Puerto Ingles'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (244, 4, 'Puerto Rosario'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (245, 4, 'Punta De Arenales'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (246, 4, 'Puntas Del Rosario(Zunin)'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (247, 4, 'Radial Hernandez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (248, 4, 'Radial Rosario'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (249, 4, 'Riachuelo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (250, 4, 'Rosario'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (251, 4, 'Rosario Y Colla'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (252, 4, 'Agraciada'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (253, 4, 'Anchorena'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (254, 4, 'Artilleros'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (255, 4, 'Barker'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (256, 4, 'Barrio Hipodromo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (257, 4, 'Belgrano Norte'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (258, 4, 'Belgrano Sur'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (259, 4, 'Blanca Arena'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (260, 4, 'Boca Del Rosario'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (261, 4, 'Brisas Del Plata'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (262, 4, 'Buena Hora'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (263, 4, 'Campana'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (264, 4, 'Canteras De Riachuelo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (265, 4, 'Carmelo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (266, 4, 'Cerro De Las Armas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (267, 4, 'Colonia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (268, 4, 'Colonia Arrue'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (269, 4, 'Colonia Cosmopolita'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (270, 4, 'Colonia De Sacramento'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (271, 4, 'Colonia Estrella'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (272, 4, 'Colonia Suiza'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (273, 4, 'Colonia Valdense'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (274, 4, 'Conchillas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (275, 4, 'Costa De Colla Al Este'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (276, 4, 'Costa De Navarro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (277, 4, 'Cufre'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (278, 4, 'Chico Torino'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (279, 4, 'El Caño'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (280, 4, 'El Cerro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (281, 4, 'El Semillero'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (282, 4, 'Estanzuela'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (283, 4, 'Florencio Sanchez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (284, 4, 'Juan Gonzalez  R.21,Km 249'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (285, 4, 'Juan Gonzalez Ruta 21 Km.243'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (286, 4, 'Juan Lacaze'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (287, 4, 'La Paz'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (288, 4, 'Las Flores'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (289, 4, 'Lomas De Carmelo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (290, 4, 'Los Cerros De San Juan'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (291, 4, 'Los Pinos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (292, 4, 'Martin Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (293, 4, 'Miguelete'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (294, 4, 'Ruta 21 Km.202'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (295, 4, 'San Juan'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (296, 4, 'San Pedro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (297, 4, 'Santa Ana'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (298, 4, 'Santa Regina'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (299, 4, 'Tarariras'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (300, 4, 'Viboras Oeste'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (301, 4, 'Zagarzazu'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (302, 5, 'Aguas Buenas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (303, 5, 'Alvarez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (304, 5, 'Barrancas Coloradas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (305, 5, 'Bellaco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (306, 5, 'Blanquillo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (307, 5, 'Blanquillo Al Oeste'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (308, 5, 'Capilla Farruco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (309, 5, 'Carlos Reyles'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (310, 5, 'Carmen'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (311, 5, 'Carpinteria'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (312, 5, 'Ceibal'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (313, 5, 'Centenario'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (314, 5, 'Cerrezuelo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (315, 5, 'Cerro Convento'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (316, 5, 'Cerro Chato'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (317, 5, 'Cuchilla De Ramirez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (318, 5, 'Chileno'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (319, 5, 'De Dios'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (320, 5, 'Durazno'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (321, 5, 'El Pescado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (322, 5, 'Estacion Chileno'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (323, 5, 'Estacion Parish'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (324, 5, 'Feliciano'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (325, 5, 'Fonseca'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (326, 5, 'La Alegria'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (327, 5, 'La Mazamorra'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (328, 5, 'La Paloma'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (329, 5, 'Las Cañas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (330, 5, 'Las Cañas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (331, 5, 'Las Rojas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (332, 5, 'Los Agregados'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (333, 5, 'Los Agueros'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (334, 5, 'Maria Cejas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (335, 5, 'Molles'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (336, 5, 'Mouriño'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (337, 5, 'Ombues Oribe'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (338, 5, 'Parada Sur Km 265'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (339, 5, 'Patovi'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (340, 5, 'Puglia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (341, 5, 'Punta De Las Flores'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (342, 5, 'Reynolds'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (343, 5, 'Rincon De Baygorria'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (344, 5, 'Rossel Y Rius'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (345, 5, 'Ruta 5 Km 172'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (347, 5, 'Salinas Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (348, 5, 'San Jorge'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (349, 5, 'San Jose De Las Cañas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (350, 5, 'Sandu Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (351, 5, 'Santa Bernardina'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (352, 5, 'Sarandi Del Rio Negro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (353, 5, 'Sarandi Del Yi'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (354, 6, 'Andresito'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (355, 6, 'Arenal Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (356, 6, 'Cerro De Jazmin'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (357, 6, 'Ismael Cortinas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (358, 6, 'Juan Jose Castro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (359, 6, 'Pueblito Piedra'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (360, 6, 'Pueblo Pintos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (361, 6, 'Puntas Del Sauce'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (362, 6, 'Santa Adelaida'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (363, 6, 'Trinidad'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (364, 7, 'Alejandro Gallinal'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (365, 7, 'Berrondo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (366, 7, 'Capilla Del Sauce'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (367, 7, 'Cardal'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (368, 7, 'Casupa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (369, 7, 'Cerro Colorado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (370, 7, 'Cerro Chato'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (371, 7, 'Chamizo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (372, 7, 'Chingolas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (373, 7, 'El Tornero'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (374, 7, 'Estacion Palermo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (375, 7, 'Ferrer'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (376, 7, 'Florida'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (377, 7, 'Fray Marcos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (378, 7, 'Frigorifico Modelo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (379, 7, 'Goñi'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (381, 7, 'Independencia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (382, 7, 'La Cruz'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (383, 7, 'Las Chilcas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (384, 7, 'Mendoza Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (386, 7, 'Mendoza Grande'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (387, 7, 'Molles Del Pescado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (388, 7, 'Monte Coral'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (389, 8, 'Nico Perez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (390, 7, 'Paraje Timote'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (391, 7, 'Pasaje Santa Teresa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (392, 7, 'Paso De Los Novillos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (393, 7, 'Pintado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (394, 7, 'Polanco Del Yi'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (395, 7, 'Pueblo De Los Morochos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (396, 7, 'Puntas De Maciel'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (397, 7, 'Reboledo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (398, 7, 'San Gabriel'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (399, 7, 'Sarandi Grande'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (400, 7, 'Talita'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (401, 8, 'Valentines'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (402, 7, 'Veinticinco De Agosto'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (403, 7, 'Veinticinco De Mayo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (404, 7, 'Villa Hipica'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (405, 7, 'Villa Vieja'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (406, 8, 'Alonso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (407, 8, 'Aramendia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (408, 8, 'Campanero'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (409, 8, 'Colon'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (410, 8, 'Diecinueve De Junio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (411, 8, 'El Soldado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (412, 8, 'Estacion Solis'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (413, 8, 'Godoy'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (414, 8, 'Higueritas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (415, 8, 'Illescas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (416, 8, 'Ing. Luis Andreoni'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (417, 8, 'Jose Batlle Y Ordoñez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (418, 8, 'Jose Pedro Varela'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (419, 8, 'Ladrillo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (420, 8, 'Las Achiras'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (421, 8, 'Mariscala'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (422, 8, 'Marmaraja'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (423, 8, 'Minas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (424, 8, 'Piraraja'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (425, 8, 'Poblado La Rosa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (427, 8, 'Polanco Norte'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (428, 8, 'Puntas De Santa Lucia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (429, 8, 'Retamosa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (430, 8, 'Rincon De Cebollati'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (431, 8, 'Ruta 40 Km 2500'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (432, 8, 'Ruta 40 Km 27,5'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (433, 8, 'Sarandi Gutierrez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (434, 8, 'Solis De Mataojo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (435, 8, 'Tapes Grande'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (436, 8, 'Tres Arboles'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (437, 8, 'Villa Del Rosario'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (438, 8, 'Villa Serrana'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (439, 8, 'Zapican'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (440, 9, 'Aigua'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (441, 9, 'Alto De Pinar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (442, 9, 'Argentino'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (443, 9, 'Balneario Buenos Aires'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (445, 9, 'Barrio Hipodromo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (446, 9, 'Barrio Los Aromos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (447, 9, 'Bella Vista'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (448, 9, 'Calera Ramos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (449, 9, 'Canteras De Marelli'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (450, 9, 'Cerro Pelado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (451, 9, 'Cerros Azules'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (452, 9, 'Chihuahua'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (453, 9, 'El Chorro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (454, 9, 'El Eden'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (455, 9, 'El Tesoro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (456, 9, 'Estacion Jose Ignacio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (457, 9, 'Faro Jose Ignacio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (458, 9, 'Garzon'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (459, 9, 'Gerona'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (460, 9, 'Gregorio Aznarez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (461, 9, 'Gregorio Perez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (462, 9, 'Jose Ignacio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (463, 9, 'La Barra'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (464, 9, 'La Capuera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (465, 9, 'Laguna Del Sauce'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (467, 9, 'Las Flores'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (468, 9, 'Las Talas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (469, 9, 'Linares Las Delicias'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (471, 9, 'Maldonado'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (472, 9, 'Manantiales'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (473, 9, 'Nueva Carrara'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (474, 9, 'Ocean Park'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (475, 9, 'Pan De Azucar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (476, 9, 'Paso De Los Talas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (477, 9, 'Picada Tolosa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (478, 9, 'Piriapolis'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (479, 9, 'Playa Grande'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (480, 9, 'Playa Hermosa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (481, 9, 'Playa Verde'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (482, 9, 'Punta Ballena'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (483, 9, 'Punta Colorada'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (484, 9, 'Punta Del Este'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (485, 9, 'Punta Negra'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (486, 9, 'Puntas De San Ignacio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (487, 9, 'Ruta 37 Y 9'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (488, 9, 'San Carlos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (489, 9, 'San Rafael El Placer'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (490, 9, 'Sauce De Aigua'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (491, 9, 'Sauce De Portezuelo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (492, 9, 'Solis'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (493, 9, 'Solis Grande'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (494, 9, 'Villa Delia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (499, 11, 'Algorta'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (500, 11, 'Alonso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (501, 11, 'Araujo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (502, 11, 'Arbolito'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (503, 11, 'Beisso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (504, 11, 'Bella Vista'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (505, 11, 'Cañada Del Pueblo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (506, 11, 'Casablanca'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (507, 11, 'Cerro Chato'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (508, 11, 'Chapicuy'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (509, 11, 'El Eucaliptus'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (510, 11, 'Esperanza'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (511, 11, 'Estacion Queguay'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (512, 11, 'Gualeguay'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (513, 11, 'Guichon'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (514, 11, 'La Tentacion'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (515, 11, 'Las Flores'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (518, 11, 'Lorenzo Geyres'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (519, 11, 'Merinos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (520, 11, 'Morato'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (521, 11, 'Nuevo Paysandu'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (522, 11, 'Orgoroso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (523, 11, 'Parada Dayman'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (524, 11, 'Paysandu'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (525, 11, 'Piedra Sola'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (526, 11, 'Piedras Coloradas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (527, 11, 'Piquera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (528, 11, 'Porvenir'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (529, 11, 'Quebracho'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (530, 11, 'San Felix'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (531, 11, 'Tambores'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (532, 11, 'Tomas Paz'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (533, 11, 'Tres Arboles'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (534, 11, 'Villa Maria (Tiatucura)'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (535, 12, 'Algorta'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (536, 12, 'Barrio Anglo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (537, 12, 'El Ombu'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (538, 12, 'Fray Bentos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (539, 12, 'Grecco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (540, 12, 'Los Arrayanes'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (541, 12, 'Menafra'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (542, 12, 'Nuevo Berlin'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (543, 12, 'Paso De La Cruz'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (544, 12, 'Paso De Los Mellizos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (546, 12, 'San Javier'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (547, 12, 'Sarandi De Navarro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (548, 12, 'Tres Arboles'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (549, 12, 'Villa Gral Borges'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (550, 12, 'Villa Maria'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (551, 12, 'Young'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (552, 13, 'Abrojal'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (553, 13, 'Amarillo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (554, 13, 'Cerrillada'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (555, 13, 'Hospital'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (556, 13, 'La Pedrera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (557, 13, 'La Puente'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (558, 13, 'Lagos Del Norte'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (559, 13, 'Lagunon'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (560, 13, 'Las Flores'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (561, 13, 'Mandubi'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (562, 13, 'Masoller'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (563, 13, 'Minas De Corrales'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (564, 13, 'Moirones'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (565, 13, 'Paso De Ataques'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (566, 13, 'Rivera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (567, 13, 'Santa Ana Do Libramento'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (568, 13, 'Santa Teresa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (569, 13, 'Tranqueras'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (570, 13, 'Vichadero'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (571, 13, 'Yaguari'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (572, 14, '18 De Julio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (573, 14, 'Aguas Dulces'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (574, 14, 'Arachania'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (575, 14, 'Barra Del Chuy'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (576, 14, 'Barrio Pereira'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (577, 14, 'Barrio Torres'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (578, 14, 'Cabo Polonio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (579, 14, 'Capacho'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (580, 14, 'Castillos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (581, 14, 'Cebollati'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (583, 14, 'Chuy'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (584, 14, 'Diecinueve De Abril'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (585, 14, 'Fondo De Valizas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (586, 14, 'La Aguada Y Costa Azul'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (587, 14, 'La Coronilla'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (588, 14, 'La Esmeralda'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (589, 14, 'La Paloma'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (591, 14, 'Lascano'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (592, 14, 'Parelle'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (593, 14, 'Punta Aguda'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (594, 14, 'Punta Castillos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (595, 14, 'Puerto De Los Botes'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (596, 14, 'Puimayen'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (597, 14, 'Punta Del Diablo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (598, 14, 'Rocha'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (599, 14, 'San Ignacio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (600, 14, 'Santa Teresa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (601, 14, 'San Luis Al Medio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (602, 14, 'Velazquez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (603, 15, 'Albisu'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (604, 15, 'Arenitas Blancas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (605, 15, 'Belen'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (606, 15, 'Biassini'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (607, 15, 'Cancela O. Varesse'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (608, 15, 'Celeste'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (609, 15, 'Constitucion'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (610, 15, 'Cuchilla De Guaviyu'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (611, 15, 'Fernandez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (612, 15, 'Garibaldi'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (613, 15, 'Guaviyu De Arapey'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (614, 15, 'Laureles'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (615, 15, 'Lluveras'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (616, 15, 'Migliaro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (617, 15, 'Salto'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (618, 15, 'San Antonio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (619, 15, 'Sarandi Del Arapey'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (620, 15, 'Saucedo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (621, 15, 'Sopas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (622, 15, 'Termas Del Arapey'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (623, 15, 'Termas Del Dayman'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (624, 15, 'Valentin Grande'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (625, 16, '18 De Julio'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (626, 16, 'Aguas Corrientes'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (627, 16, 'Autodromo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (628, 16, 'Bocas Del Cufre'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (629, 16, 'Capurro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (630, 16, 'Colonia Wilson'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (631, 16, 'Chamizo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (632, 16, 'Delta Del Tigre'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (633, 16, 'Ecilda Paullier'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (634, 16, 'Gonzalez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (635, 16, 'Ituzaingo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (636, 16, 'Juan Soler'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (638, 16, 'Kiyu-Ordeig'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (639, 16, 'La Boyada'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (640, 16, 'Libertad'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (641, 16, 'Mal Abrigo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (642, 16, 'Monte Grande'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (643, 16, 'Parque Postel'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (644, 16, 'Playa Pascual'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (645, 16, 'Puntas De Valdez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (646, 16, 'Rafael Perazza'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (647, 16, 'Raigon'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (648, 16, 'Rapetti'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (649, 16, 'Rincon De La Bolsa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (650, 16, 'Rincon Del Pino'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (651, 16, 'Rodriguez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (652, 16, 'San Fernando'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (653, 16, 'San Jose De Mayo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (654, 16, 'Santa Monica'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (655, 16, 'Scavino'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (656, 16, 'Valdes Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (657, 16, 'Villa Ituzaingo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (658, 16, 'Villa Maria'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (659, 16, 'Villa Rives'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (660, 16, 'Villa Rodriguez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (661, 17, 'Egaña'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (662, 17, 'Agraciada'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (663, 17, 'Cañada Nieto'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (664, 17, 'Cardona'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (665, 17, 'Carmen'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (666, 17, 'Castillos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (667, 17, 'Colonia Larrañga'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (668, 17, 'Dolores'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (669, 17, 'Jose Enrique Rodo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (670, 17, 'La Concordia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (671, 17, 'La Loma'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (672, 17, 'Mercedes'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (673, 17, 'Palmar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (674, 17, 'Palmitas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (675, 17, 'Palo Solo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (676, 17, 'Risso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (677, 17, 'San Salvador'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (678, 17, 'Santa Catalina'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (679, 17, 'Villa Darwin'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (680, 17, 'Villa De Soriano'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (682, 18, 'Achar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (683, 18, 'Batovi'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (684, 18, 'Caraguata'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (686, 18, 'Cardoso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (687, 18, 'Cuchilla Del Ombu'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (688, 18, 'Curtina'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (689, 18, 'Chamberlain'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (690, 18, 'Charata'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (691, 18, 'Churchill'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (692, 18, 'Guaviyu'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (693, 18, 'La Pedrera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (694, 18, 'Las Toscas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (695, 18, 'Laureles'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (696, 18, 'Montevideo Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (697, 18, 'Paso Bonilla'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (698, 18, 'Paso De Los Toros'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (699, 18, 'Paso Del Cerro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (700, 18, 'Paso Hondo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (701, 18, 'Peralta'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (702, 18, 'Piedra Sola'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (703, 18, 'Rincon De Tranqueras'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (704, 18, 'Rincon De Zamora'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (705, 18, 'Rincon Del Bonete'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (706, 18, 'San Gregorio De Polanco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (707, 18, 'Sauce De Batovi'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (708, 18, 'Tacuarembo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (709, 18, 'Tambores'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (710, 18, 'Valle Eden'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (711, 18, 'Villa Ansina'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (712, 19, 'Acosta'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (713, 19, 'Alonso'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (714, 19, 'Batlle Y Ordoñez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (715, 19, 'Cerro Chato'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (716, 19, 'Cerros De Amaro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (717, 19, 'Ejido De Treinta Y Tres'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (718, 19, 'Estacion Rincon'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (719, 19, 'Gral. Enrique Martinez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (720, 19, 'Isla Patrulla'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (721, 19, 'Maria Albina'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (722, 19, 'Mendizabal'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (723, 19, 'Olimar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (724, 19, 'Santa Clara De Olimar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (725, 19, 'Treinta Y Tres'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (726, 19, 'Valentines'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (727, 19, 'Vergara'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (728, 19, 'Villa Passano'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (729, 19, 'Villa Sara'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (730, 11, 'San Javier'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (731, 7, '25 de Agosto'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (732, 7, '25 de Mayo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (733, 9, 'Pinares - Las Delicias'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (734, 10, 'Ciudad Vieja'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (735, 10, 'Centro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (736, 10, 'Barrio Sur'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (737, 10, 'Cordón'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (738, 10, 'Palermo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (739, 10, 'Parque Rodó'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (740, 10, 'Punta Carretas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (741, 10, 'Pocitos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (742, 10, 'Buceo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (743, 10, 'Parque Batlle, Villa Dolores'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (744, 10, 'Malvín'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (745, 10, 'Malvín Norte'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (746, 10, 'Punta Gorda'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (747, 10, 'Carrasco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (748, 10, 'Carrasco Norte'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (749, 10, 'Bañados de Carrasco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (750, 10, 'Maroñas, Parque Guaraní'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (751, 10, 'Flor de Maroñas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (752, 10, 'Las Canteras'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (753, 10, 'Punta de Rieles, Bella Italia'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (754, 10, 'Jardines del Hipódromo'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (755, 10, 'Ituzaingó'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (756, 10, 'Unión'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (757, 10, 'Villa Española'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (758, 10, 'Mercado Modelo, Bolívar'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (759, 10, 'Castro, Pérez Castellanos'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (760, 10, 'Cerrito de la Victoria'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (761, 10, 'Las Acacias'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (762, 10, 'Aires Puros'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (763, 10, 'Casavalle'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (764, 10, 'Piedras Blancas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (765, 10, 'Manga, Toledo Chico'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (766, 10, 'Paso de las Duranas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (767, 10, 'Peñarol, Lavalleja'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (768, 10, 'Villa del Cerro'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (769, 10, 'Casabó, Pajas Blancas'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (770, 10, 'La Paloma, Tomkinson'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (771, 10, 'La Teja'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (772, 10, 'Prado, Nueva Savona'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (773, 10, 'Capurro, Bella Vista, Arroyo Seco'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (774, 10, 'Aguada'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (775, 10, 'Reducto'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (776, 10, 'Atahualpa'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (777, 10, 'Jacinto Vera'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (778, 10, 'La Figurita'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (779, 10, 'Larrañaga'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (780, 10, 'La Blanqueada'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (781, 10, 'Villa Muñoz, Retiro, Goes'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (782, 10, 'La Comercial'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (783, 10, 'Tres Cruces'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (784, 10, 'Brazo Oriental'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (785, 10, 'Sayago'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (786, 10, 'Conciliación'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (787, 10, 'Belvedere, Paso Molino'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (788, 10, 'Nuevo París'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (789, 10, 'Tres Ombúes, Pueblo Victoria'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (790, 10, 'Paso de la Arena, Santiago Vázquez'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (791, 10, 'Colón Sureste, Abayubá'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (792, 10, 'Colón Centro y Noroeste'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (793, 10, 'Lezica, Melilla'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (794, 10, 'Villa García, Manga Rural'); 
	insert into ruffo.localidad (id, departamento_id, descripcion) values (795, 10, 'Manga'); 

COMMIT;