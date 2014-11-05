DROP DATABASE IF EXISTS pos_java;
CREATE DATABASE pos_java DEFAULT CHARACTER SET utf8;
use pos_java;

create table categories (
  id int auto_increment not null primary key,
  name varchar(20)
);
insert into categories values(null, 'drink');
insert into categories values(null, 'snut');
insert into categories values(null, 'fruit');

create table items(
  id int auto_increment,
  categoryId int,
  barcode varchar(14) not null,
  name varchar(20) not null,
  unit varchar(4) not null,
  price double,
  primary key(id),
  foreign key(categoryId) references categories(id)
);
insert into items values(null, 3,'ITEM000001', 'apple', 'kg', 8.0);
insert into items values(null, 1, 'ITEM000002', 'cocacola', 'can', 2.5);
insert into items values(null, 1, 'ITEM000003', 'juice', 'can', 4.0);
insert into items values(null, 2, 'ITEM000004', 'chocolate', 'bar', 7.5);
insert into items values(null, 3, 'ITEM000005', 'strawberry', 'kg', 25.0);

create table promotions(
  id int auto_increment,
  description varchar(200) not null,
  type int not null,
  primary key(id)
);
insert into promotions values(null, 'buy_two_one_free', 1);
insert into promotions values(null, 'second_half_price', 2);
insert into promotions values(null, 'discount', 3);

create table relationship(
  itemId int,
  promotionId int,
  discount double ,
  primary key(itemId, promotionId),
  foreign key(itemId) references items(id),
  foreign key(promotionId) references promotions(id)
);
insert into relationship values (1, 1, null);
insert into relationship values (3, 1, null);
insert into relationship values (5, 1, null);
insert into relationship values (1, 2, null);
insert into relationship values (3, 2, null);
insert into relationship values (5, 2, null);
insert into relationship values (1, 3, 0.75);
insert into relationship values (3, 3, 0.85);
insert into relationship values (5, 3, 0.90);

COMMIT;