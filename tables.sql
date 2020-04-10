CREATE TABLE Usuarios (
    nombre varchar(50)  NOT NULL,
    correo varchar(150)  NOT NULL,
    contraseña varchar(50)  NOT NULL,
    estado varchar(10)  NOT NULL,
    rol varchar(15)  NOT NULL,
    CONSTRAINT Usuarios_pk PRIMARY KEY (correo)
);
