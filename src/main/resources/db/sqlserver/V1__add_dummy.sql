create sequence  typology_sequence start with  1 increment by  1;
create table tbl_typology
(
    typology_id        bigint not null identity (160001,1) primary key,
    description        varchar(250),
    parent_typology_id bigint default 0
);

create sequence  fiscalia_sequence start with  1 increment by  1;

create table adm_fiscalia
(
    fiscalia_id  bigint       not null identity (1,1) primary key,
    name         varchar(250) not null default '%',
    address_line varchar(250) not null default '%',
    country      bigint       not null default 160000,
    state        bigint       not null default 160000,
    city         bigint       not null default 160000,
    zone         bigint       not null default 160000,
    phone        bigint       not null default 0,
    phone_2      bigint       not null default 0,
    swdatecreted datetime     not null default GETDATE()
)


