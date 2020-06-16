drop table if exists addresses;

create table addresses (
address_id bigint AI PK,
city varchar(255),
state varchar(255),
street varchar(255),
zipcode varchar(255)
);

drop table if exists bills;

create table bills (
bill_id bigint AI PK,
bill_number int ,
checkout_date date,
final_rate double
);

drop table if exists guests;

create table guests (
user_id bigint PK
);

drop table if exists reservations;

create table reservations (
reservation_id bigint AI PK ,
number_of_nights int ,
reservation_date date ,
roomtype_id bigint
);

drop table if exists roles;

create table roles (
role_id int AI PK ,
name varchar(255)
);

drop table if exists rooms;

create table rooms (
room_id bigint AI PK ,
room_number int ,
room_status int ,
roomtype_id bigint
);

drop table if exists roomtypes;

create table roomtypes (
roomtype_id bigint AI PK,
description varchar(255) ,
image_path varchar(255) ,
price double ,
type varchar(255)
);

drop table if exists users;

create table users (
user_id bigint AI PK ,
cell_phone_number varchar(255) ,
email varchar(255) ,
enabled bit(1) ,
first_name varchar(255) ,
last_name varchar(255) ,
password varchar(255) ,
username varchar(255) ,
address_id bigint
);

drop table if exists users_roles;

create table users (
user_id bigint PK ,
role_id int PK
);