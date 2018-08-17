create table customers
(
  id       int auto_increment
    primary key,
  name     varchar(255) null,
  surname  varchar(255) null,
  phone    varchar(255) null,
  address  varchar(500) null,
  birthday date         null
)
  charset = latin1;

create table employees
(
  id      int auto_increment
    primary key,
  name    varchar(255)   null,
  surname varchar(255)   null,
  phone   varchar(255)   null,
  address varchar(500)   null,
  note    varchar(500)   null,
  wage    decimal(10, 2) null
)
  charset = latin1;

create table vehicles
(
  id           int auto_increment
    primary key,
  make         varchar(255) null,
  model        varchar(255) null,
  manufactured int          null,
  regNumber    varchar(255) null,
  nextReview   date         null,
  customer_id  int          not null,
  constraint vehicles_ibfk_1
  foreign key (customer_id) references customers (id)
)
  charset = latin1;

create table orders
(
  id           int auto_increment
    primary key,
  carAccepted  datetime       not null,
  plannedStart datetime       null,
  actualStart  datetime       not null,
  problemDesc  varchar(500)   null,
  repairDesc   varchar(500)   null,
  status       varchar(255)   null,
  vehicle_id   int            not null,
  repairCost   decimal(10, 2) null,
  partsCost    decimal(10, 2) null,
  wage         decimal(10, 2) null,
  manhours     decimal(10, 2) null,
  employee_id  int            not null,
  constraint orders_ibfk_2
  foreign key (vehicle_id) references vehicles (id),
  constraint orders_ibfk_1
  foreign key (employee_id) references employees (id)
)
  charset = latin1;

create index `_ibfk_1`
  on orders (employee_id);

create index `_ibfk_2`
  on orders (vehicle_id);

create index vehicles_ibfk_1
  on vehicles (customer_id);


