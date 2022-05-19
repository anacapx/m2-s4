create database ccap;

create table product_tb (
  product_id serial primary key,
  product_name varchar(50) not null,
  product_description varchar(100) not null,
  product_price double precision not null,
  product_stock int not null
);

create table customer_tb (
  customer_id serial primary key,
  customer_email varchar(100) not null unique,
  customer_name varchar(255) not null,
  customer_cpf varchar(11) not null unique,
  customer_cep varchar(8) not null,
  customer_password varchar(255)
);

create table order_status_tb (
  status_id smallint not null primary key,
  status_description varchar(255),
  status_name varchar(255)
);

create table order_tb (
  order_id serial primary key,
  order_status smallint,
  customer_id int,
  order_date timestamp,
  total_before_discount double precision,
  discount double precision,
  total_after_discount double precision,
  constraint fk_order_status foreign key (order_status) references order_status_tb(status_id),
  constraint fk_order_customer foreign key (customer_id) references customer_tb(customer_id)

);


create table item_tb (
  item_id serial primary key,
  order_item int not null,
  order_id int not null,
  product_id int not null,
  quantity int not null,
  un_price double precision not null,
  total_price double precision  not null,
  constraint fk_item_order foreign key (order_id) references order_tb(order_id),
  constraint fk_item_product foreign key (product_id) references product_tb(product_id)
);