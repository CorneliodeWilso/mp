create sequence if not exists typology_sequence start with 1 increment by 1;
create table if not exists tbl_typology
(
    typology_id        bigint not null default nextval('typology_sequence') primary key,
    description        varchar(250),
    parent_typology_id bigint          default 0
);

create sequence if not exists fiscalia_sequence start with 1 increment by 1;

create table if not exists adm_fiscalia
(
    fiscalia_id  bigint       not null default nextval('fiscalia_sequence') primary key,
    name         varchar(250) not null default '%',
    address_line varchar(250) not null default '%',
    country      bigint       not null default 160000,
    state        bigint       not null default 160000,
    city         bigint       not null default 160000,
    zone         bigint       not null default 160000,
    phone        bigint       not null default 0,
    phone_2      bigint       not null default 0,
    swdatecreted timestamp    not null default '1900-01-01 00:00:00'
)
