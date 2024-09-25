drop table if EXISTS book;
create table book(
id int primary key auto_increment,
title varchar(200) not null,
author varchar(200) not null,
price DOUBLE not null,
category varchar(200) not null
);

drop table if EXISTS cart_item;
create table cart_item (
id int primary key auto_increment,
book_id int not null,
shopping_cart_id int not null,
quantity int not null
);

drop table if EXISTS shopping_cart;
create table shopping_cart (
id int primary key auto_increment,
user_id int not null
);