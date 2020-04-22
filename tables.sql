create table if not exists usuarios
(
    nombre     varchar(50)  ,
    correo     varchar(150) not null
        constraint usuarios_pk
            primary key,
    contraseña varchar(50)  ,
    estado     varchar(10)  ,
    rol        varchar(15)
);
create table if not exists iniciativas
(
    id                 integer      not null
        constraint iniciativas_pk
            primary key,
    nombre             varchar(150) not null,
    area               varchar(50)  not null,
    estado             varchar(20)  not null,
    proponente         varchar(150) not null
        constraint iniciativas_usuarios
            references usuarios,
    fecha_creacion     date         not null,
    fecha_finalizacion date,
    descripcion        varchar(360) not null
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



=======

create table if not exists iniciativas
(
    id                 integer      not null
        constraint iniciativas_pk
            primary key,
    nombre             varchar(150) not null,
    area               varchar(50)  not null,
    estado             varchar(20)  not null,
    proponente         varchar(150) not null
        constraint iniciativas_usuarios
            references usuarios,
    fecha_creacion     date         not null,
    fecha_finalizacion date,
    descripcion        varchar(360) not null
);

create table if not exists palabras_clave
(
    id            integer     not null
        constraint palabras_clave_pk
            primary key,
    palabra_clave varchar(20) not null,
    iniciativa    integer     not null
        constraint palabras_clave_iniciativas
            references iniciativas
);

create table if not exists votos
(
    id         integer      not null
        constraint votos_pk
            primary key,
    iniciativa integer      not null
        constraint votos_iniciativas
            references iniciativas,
    autor      varchar(150) not null
        constraint usuarios_votos
            references usuarios
);

create table if not exists comentarios
(
    id             integer      not null
        constraint comentarios_pk
            primary key,
    autor          varchar(150) not null
        constraint comentarios_usuarios
            references usuarios,
    contenido      varchar(500) not null,
    fecha_creacion date         not null,
    iniciativa     integer      not null
        constraint iniciativas_comentarios
            references iniciativas
);

create table if not exists estrellas
(
    id         integer      not null
        constraint estrellas_pk
            primary key,
    interesado varchar(150) not null
        constraint grupo_interes_usuarios
            references usuarios,
    iniciativa integer      not null
        constraint estrellas_iniciativas
            references iniciativas
);

create table if not exists integrantes_proyecto
(
    id         integer      not null
        constraint integrantes_proyecto_pk
            primary key,
    integrante varchar(150) not null
        constraint equipo_proyectos_usuarios
            references usuarios,
    iniciativa integer      not null
        constraint integrantes_proyecto_iniciativas
            references iniciativas
);

insert into usuarios values ('admin', 'admin@gmail.com', 'admin', 'ACTIVO', 'ADMINISTRADOR');
insert into usuarios values ('test', 'test@gmail.com', 'test', 'ACTIVO', 'PUBLICO');
insert into iniciativas(id, nombre, area, estado, proponente, fecha_creacion, descripcion) values ('0', 'Prueba', 'Prueba', 'ESPERA', 'test@gmail.com', '2020-4-19', 'Iniciativa de prueba');
>>>>>>> davor
