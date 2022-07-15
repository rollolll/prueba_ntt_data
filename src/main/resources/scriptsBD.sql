create table afiliados
(
    id        serial
        constraint afiliados_pk
            primary key,
    nombre    varchar not null,
    apellido  varchar not null,
    documento varchar not null
);

alter table afiliados
    owner to postgres;

create table casos
(
    id                 serial
        constraint casos_pk
            primary key,
    documento_afiliado varchar not null,
    descripcion        varchar not null,
    estado             varchar
);

alter table casos
    owner to postgres;


