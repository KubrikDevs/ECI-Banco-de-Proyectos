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
    id         serial      not null
        constraint votos_pk
            primary key,
    iniciativa integer      not null
        constraint votos_iniciativas
            references iniciativas,
    autor      varchar(150) not null
        constraint usuarios_votos
            references usuarios
);

create table comentarios
(
    id             serial       not null
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
