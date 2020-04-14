CREATE TABLE Usuarios (
    nombre varchar(50)  NOT NULL,
    correo varchar(150)  NOT NULL,
    contraseña varchar(50)  NOT NULL,
    estado varchar(10)  NOT NULL,
    rol varchar(15),
    CONSTRAINT Usuarios_pk PRIMARY KEY (correo)
);

CREATE TABLE Iniciativa (
    id int  NOT NULL,
    nombre varchar(150)  NOT NULL,
    estado varchar(50)  NOT NULL,
    numVotos int  NOT NULL,
    usuarioProponente varchar(150),
    area varchar(50)  NOT NULL,
    fechaCreacion date  NOT NULL,
    fechaFin date  NOT NULL,
    descripcion varchar(360) NOT NULL,
    CONSTRAINT Iniciativa_pk PRIMARY KEY (id)
);

ALTER TABLE Iniciativa ADD CONSTRAINT Iniciativa_usuario
    FOREIGN KEY (usuarioProponente)
    REFERENCES Usuarios(correo);

