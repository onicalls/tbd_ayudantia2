create database cambiarnombre;
create extension postgis;


create table if not exists establecimientos
(
    establecimientocodigo                   integer,
    establecimientoglosa                    text,
    establecimientocodigoantiguo            text,
    establecimientocodigomadreantiguo       text,
    establecimientocodigomadrenuevo         double precision,
    regioncodigo                            integer,
    regionglosa                             text,
    seremisaludcodigo_serviciodesaludcodigo double precision,
    seremisaludglosa_serviciodesaludglosa   text,
    tipopertenenciaestabglosa               text,
    tipoestablecimientoglosa                text,
    ambitofuncionamiento                    text,
    certificacion                           text,
    dependenciaadministrativa               text,
    nivelatencionestabglosa                 text,
    comunacodigo                            text,
    comunaglosa                             text,
    tipoviaglosa                            text,
    numero                                  text,
    nombrevia                               text,
    telefonomovil_telefonofijo              text,
    fechainiciofuncionamientoestab          text,
    tieneserviciourgencia                   text,
    tipourgencia                            text,
    clasificaciontiposapu                   text,
    latitud                                 text,
    longitud                                text,
    tiposistemasaludglosa                   text,
    estadofuncionamiento                    text,
    nivelcomplejidadestabglosa              text,
    tipoatencionestabglosa                  text,
    fechaincorporacion                      text
);

alter table establecimientos
    owner to postgres;

create table if not exists pos_establecimientos
(
    establecimientocodigo integer not null primary key,
    latitud               double precision,
    longitud              double precision,
    geom                  geometry(Point, 4326)
);

alter table pos_establecimientos
    owner to postgres;

create view vista_establecimientos (establecimientocodigo, establecimientoglosa, regionglosa, latitud, longitud, pos) as
SELECT e.establecimientocodigo,
       e.establecimientoglosa,
       e.regionglosa,
       pe.latitud,
       pe.longitud,
       pe.geom AS pos
FROM establecimientos e
         LEFT JOIN pos_establecimientos pe ON e.establecimientocodigo = pe.establecimientocodigo;

alter table vista_establecimientos
    owner to postgres;

CREATE TABLE IF NOT EXISTS public.users
(
    username character varying(20) COLLATE pg_catalog."default" NOT NULL,
    password character varying(200) COLLATE pg_catalog."default" NOT NULL,
    email character varying(50) COLLATE pg_catalog."default",
    rol character varying(200) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (username)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;
