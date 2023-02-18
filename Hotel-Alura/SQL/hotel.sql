
/* Crear tablas */
CREATE TABLE reservas(
Id INT AUTO_INCREMENT,
FechaEntrada DATE,
FechaSalida DATE,
Valor FLOAT,
FormaPago ENUM('Tarjeta de Credito','Tarjeta de Debito','Efectivo'),
PRIMARY KEY(Id));

CREATE TABLE huespedes(
Id INT AUTO_INCREMENT,
Nombre VARCHAR(30) NOT NULL CHECK(Nombre REGEXP '^[a-zA-Z]+$'),
Apellido VARCHAR(30) NOT NULL CHECK(Apellido REGEXP '^[a-zA-Z]+$'),
FechaDeNacimiento DATE,
Nacionalidad VARCHAR(20),
Telefono VARCHAR(23) CHECK(Telefono REGEXP '^[0-9]+$'),
IdReserva INT,
FOREIGN KEY (IdReserva) REFERENCES reservas(Id),
PRIMARY KEY(Id)
);

CREATE TABLE usuarios (
Id INT AUTO_INCREMENT,
NombreUsuario VARCHAR(30) NOT NULL CHECK(Nombre REGEXP '^[a-zA-Z]+$'),
Password VARCHAR(30) NOT NULL,
IdReserva INT,
IdHuesped INT,
FOREIGN KEY (IdReserva) REFERENCES reservas(Id),
FOREIGN KEY (IdHuesped) REFERENCES huespedes(Id),
PRIMARY KEY (Id),
UNIQUE (Password)
);

/* Modificacion */
ALTER TABLE reservas MODIFY FormaPago ENUM('Tarjeta de Credito','Tarjeta de Debito','Efectivo');


/* DATOS  */
INSERT INTO reservas(FechaEntrada,FechaSalida,FormaPago) 
VALUES("2022-06-23","2022-06-24","Tarjeta de Debito");

INSERT INTO reservas(FechaEntrada,FechaSalida,Valor,FormaPago) 
VALUES
("2022-06-28","2022-06-29",180,"Tarjeta de Credito"),
("2022-06-28","2022-08-15",8640,"Efectivo"),
("2022-08-26","2022-08-30",720,"Tarjeta de Credito"),
("2022-09-01","2022-09-08",1260,"Tarjeta de Debito"),
("2022-09-01","2022-09-08",1260,"Tarjeta de Debito"),
("2022-09-01","2022-09-08",1260,"Tarjeta de Debito"),
("2022-09-01","2022-09-08",1260,"Tarjeta de Debito"),
("2022-09-01","2022-09-08",1260,"Tarjeta de Debito"),
("2022-09-01","2022-09-08",1260,"Tarjeta de Debito"),
("2022-09-01","2022-09-08",1260,"Tarjeta de Debito"),
("2022-09-01","2022-09-02",180,"Tarjeta de Credito"),
("2022-09-01","2022-09-02",180,"Tarjeta de Credito");

INSERT INTO usuarios(NombreUsuario,Password) 
VALUES("Cristian","asd123");

INSERT INTO huespedes(Nombre,Apellido,FechaDeNacimiento,Nacionalidad,Telefono,IdReserva)
VALUES("Cristian","Diaz Vega","2023-09-21","Argetina","23457698",123);

/* CONSUTAS */
SELECT * FROM reservas;
SELECT * FROM reservas WHERE Valor >= 1000;
SELECT NombreUsuario, Password FROM usuarios WHERE NombreUsuario="Cristian" AND Password="12345";
select * from huespedes where Id LIKE "3%";


/* MODIFICACIONES*/
ALTER TABLE huespedes ADD CONSTRAINT noNumero CHECK(Nombre REGEXP '^[a-zA-Z]+$');

/* ELIMINAR DATOS*/

DELETE FROM reservas WHERE Id = 20;

/*UPDATE DATOS*/
UPDATE huespedes SET Apellido="Cortes" WHERE Id=23;
