CREATE TABLE Usuarios (
    nombre varchar(50)  NOT NULL,
    correo varchar(150)  NOT NULL,
    contraseña varchar(50)  NOT NULL,
    estado varchar(10)  NOT NULL,
    rol varchar(15)  NOT NULL,
    CONSTRAINT Usuarios_pk PRIMARY KEY (correo)
);
CREATE TABLE Iniciativas (
    id int  NOT NULL,
    nombre varchar(150)  NOT NULL,
    area Varchar(50)  NOT NULL,
    estado varchar(20)  NOT NULL,
    proponente varchar(150)  NOT NULL,
    fecha_creacion date  NOT NULL,
    fecha_finalizacion date  NOT NULL,
    descripcion varchar(360)  NOT NULL,
    CONSTRAINT Iniciativas_pk PRIMARY KEY (id)
);

CREATE TABLE Palabras_clave (
    id int  NOT NULL,
    palabra_clave varchar(20)  NOT NULL,
    iniciativa int  NOT NULL,
    CONSTRAINT Palabras_clave_pk PRIMARY KEY (id)
);

CREATE TABLE Votos (
    id int  NOT NULL,
    Iniciativa int  NOT NULL,
    autor varchar(150)  NOT NULL,
    CONSTRAINT Votos_pk PRIMARY KEY (id)
);

CREATE TABLE Comentarios (
    id int  NOT NULL,
    autor varchar(150)  NOT NULL,
    contenido varchar(500)  NOT NULL,
    fecha_creacion date  NOT NULL,
    iniciativa int  NOT NULL,
    CONSTRAINT Comentarios_pk PRIMARY KEY (id)
);

-- Table: Estrellas
CREATE TABLE Estrellas (
    id int  NOT NULL,
    interesado varchar(150)  NOT NULL,
    Iniciativa int  NOT NULL,
    CONSTRAINT Estrellas_pk PRIMARY KEY (id)
);

-- Table: Integrantes_Proyecto
CREATE TABLE Integrantes_Proyecto (
    id int  NOT NULL,
    integrante varchar(150)  NOT NULL,
    Iniciativa int  NOT NULL,
    CONSTRAINT Integrantes_Proyecto_pk PRIMARY KEY (id)
);


-- foreign keys
-- Reference: Comentarios_Usuarios (table: Comentarios)
ALTER TABLE Comentarios ADD CONSTRAINT Comentarios_Usuarios
    FOREIGN KEY (autor)
    REFERENCES Usuarios (correo)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Equipo_Proyectos_Usuarios (table: Integrantes_Proyecto)
ALTER TABLE Integrantes_Proyecto ADD CONSTRAINT Equipo_Proyectos_Usuarios
    FOREIGN KEY (integrante)
    REFERENCES Usuarios (correo)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Estrellas_Iniciativas (table: Estrellas)
ALTER TABLE Estrellas ADD CONSTRAINT Estrellas_Iniciativas
    FOREIGN KEY (Iniciativa)
    REFERENCES Iniciativas (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Grupo_Interes_Usuarios (table: Estrellas)
ALTER TABLE Estrellas ADD CONSTRAINT Grupo_Interes_Usuarios
    FOREIGN KEY (interesado)
    REFERENCES Usuarios (correo)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Iniciativas_Comentarios (table: Comentarios)
ALTER TABLE Comentarios ADD CONSTRAINT Iniciativas_Comentarios
    FOREIGN KEY (iniciativa)
    REFERENCES Iniciativas (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Iniciativas_Usuarios (table: Iniciativas)
ALTER TABLE Iniciativas ADD CONSTRAINT Iniciativas_Usuarios
    FOREIGN KEY (proponente)
    REFERENCES Usuarios (correo)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Integrantes_Proyecto_Iniciativas (table: Integrantes_Proyecto)
ALTER TABLE Integrantes_Proyecto ADD CONSTRAINT Integrantes_Proyecto_Iniciativas
    FOREIGN KEY (Iniciativa)
    REFERENCES Iniciativas (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Palabras_clave_Iniciativas (table: Palabras_clave)
ALTER TABLE Palabras_clave ADD CONSTRAINT Palabras_clave_Iniciativas
    FOREIGN KEY (iniciativa)
    REFERENCES Iniciativas (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Usuarios_Votos (table: Votos)
ALTER TABLE Votos ADD CONSTRAINT Usuarios_Votos
    FOREIGN KEY (autor)
    REFERENCES Usuarios (correo)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Votos_Iniciativas (table: Votos)
ALTER TABLE Votos ADD CONSTRAINT Votos_Iniciativas
    FOREIGN KEY (Iniciativa)
    REFERENCES Iniciativas (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;



