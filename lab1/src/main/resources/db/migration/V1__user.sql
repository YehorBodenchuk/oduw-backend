create sequence user_seq start with 1 increment by 1 no minvalue no maxvalue;

create table app_user(
    id bigint,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null unique,
    role varchar(255) not null,
    constraint pkUser primary key (id)
);
