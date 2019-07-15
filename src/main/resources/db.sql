drop table if exists address;

create table `address`(
    `id` int not null auto_increment,
    `city` varchar2(100),
    `post_code` varchar2(100),
    primary key (`id`)
);

drop table if exists device;

create table device(
    `id` int not null auto_increment,
    `name` varchar2(100),
    `description` varchar2(300),
    `price` double not null,
    primary key (`id`),
);

drop table if exists device_offer;

create table `device_offer`(
    `device_id` int not null,
    `offer_id` int not null
);


drop table if exists customer;

CREATE TABLE `customer`(
    `id` int not null auto_increment,
    `first_name` varchar2(100),
    `last_name` varchar2(100),
    `address_id` number,
    primary key (`id`),

);

drop table if exists offer;

create table `offer`(
    id int not null auto_increment,
    offer_name varchar2(100),
    price double not null,
    discount int,
    primary key (`id`)
);

insert into offer(offer_name, price, discount) values ('oferta1', 23,44.1);

