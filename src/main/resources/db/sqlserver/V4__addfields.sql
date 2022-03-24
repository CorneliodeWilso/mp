create sequence if not exists cliente_sequence start with 1606780 increment by 1 ;

create table if not exists  adm_cliente
(
    cliente_id        bigint not null primary key default nextval('cliente_sequence') ,
    name        varchar(250),
    primer_apellido varchar(100),
    segundo_apellido varchar(100),
    dpi bigint default 0
    );