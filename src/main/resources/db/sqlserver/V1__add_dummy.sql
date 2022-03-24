create sequence if not exists adm_typology_sequence start with 1606780 increment by 1 ;

create table if not exists  adm_typology
(
    typology_id        bigint not null primary key default nextval('adm_typology_sequence') ,
    description        varchar(250),
    parent_typology_id bigint default 0
    );

create sequence if not exists adm_fiscalia_sequence start with 1 increment by 1 ;

create table if not exists adm_fiscalia
(
    fiscalia_id  bigint       not null primary key default nextval('adm_fiscalia_sequence') ,
    name         varchar(250) not null default '%',
    address_line varchar(250) not null default '%',
    country      bigint       not null default 160000,
    state        bigint       not null default 160000,
    city         bigint       not null default 160000,
    zone         bigint       not null default 160000,
    phone        bigint       not null default 0,
    phone_2      bigint       not null default 0,
    swdatecreted timestamp     not null default NOW()
    )


