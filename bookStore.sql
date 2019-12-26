create database bookstore
DEFAULT CHARACTER SET utf8;
use bookstore;
create table book(
isbn_book_id int unsigned not null primary key,
isbn_2 int unsigned not null unique,
title varchar(50) not null,
publication_Year date,
-- edition ?, --
available_quantity int unsigned not null,
book_language varchar(50) not null,
cover_page varchar(50) not null,
image blob,
price float(10) not null, 
price_with_discount float(10) not null,
publisher varchar(50) not null,
pages float(1000) not null,
dimensions int unsigned not null,
weight float(10) not null,
-- image blob, --
summary varchar(1000) not null,
author_id int unsigned not null,
constraint fk_author_id foreign key (author_id)
references author (author_id),
constraint fk_book_category_id foreign key (book_category_id)
references customer (book_category_id)
);

create table author(
author_id int unsigned not null primary key,
first_name varchar(50) not null,
last_name varchar(50) not null,
author_biography varchar(500) not null
);

create table customer(
customer_id int unsigned not null primary key ,
first_name varchar(40) not null,
last_name varchar(40) not null,
mobile_phone int unsigned not null,
telephone_number int unsigned,
address_id int unsigned not null,
constraint fk_address_id foreign key (address_id)
references address (address_id)
);
create table address(
address_id int unsigned primary key not null,
street varchar(45) not null,
street_number varchar(10) not null,
city varchar(50) not null,
zip_code int unsigned not null
);
create table orders(
orders_id int unsigned primary key not null,
customer_id int unsigned not null,
constraint fk_customer_id foreign key (customer_id)
references customer (customer_id),
toys_id int unsigned not null,
constraint fk_toys_id foreign key (toys_id)
references toys (toys_id),
book_id int unsigned not null,
constraint fk_book_id foreign key (book_id)
references book (book_id),
school_supplies_id int unsigned not null,
constraint fk_school_supplies_id foreign key (school_supplies_id)
references book (school_supplies_id)
);
create table book_category(
book_category_id int unsigned primary key not null,
category_description varchar(40) not null
);
create table toys(
toys_id int unsigned primary key not null,
toys_category_id int unsigned not null,
title varchar(50) not null,
age int unsigned not null,
toys_description varchar(1000) not null,
toys_price float(50) not null,
constraint fk_toys_category_id foreign key (toys_category_id)
references toys (toys_category_id)

);
create table toys_category(
toys_category_id int unsigned primary key not null,
toys_description varchar(40) not null
);

create table school_supplies(
school_supplies_id int unsigned primary key not null,
bags varchar(50) not null,
age int unsigned not null,
pen varchar(20) not null,
pencil varchar(20) not null,
pencils_sharpener varchar(20) not null,
exercise_book varchar(20) not null,
eraser varchar(20) not null,
pencil_case varchar(20) not null
);
create table school_supplies_category(
school_supplies_category_id int unsigned primary key not null,
school_supplies_description varchar(40) not null
);

create table reviews(
reviews_id int unsigned primary key not null,
reviews_description varchar(100) not null,
-- rating-- 
customer_id int unsigned not null,
constraint fk_customer_id foreign key (customer_id)
references toys (customer_id),
book_id int unsigned not null,
constraint fk_book_id foreign key (book_id)
references toys (book_id)
 );
-- create table account(); --
-- create table loggin(); --
create table payment(
payment_id int unsigned primary key not null,
cash_on_delivery varchar(50) not null
);

