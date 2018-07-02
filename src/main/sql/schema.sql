create database petdog_db;
use petdog_db;

create table login(
id int(11) not null auto_increment,
loginname varchar(8) not null,
password varchar(8) not null check(len(password)>=8 and len(password)<=20),
PRIMARY KEY (id)
)engine=innodb auto_increment=1 default charset=utf8 comment="登录表";

create table user(
id int(11) not null auto_increment,
photo blob not null,
name varchar(8) not null,
sex int(11) not null ,
birthday datetime not null,
tel varchar(11) not null,
email varchar(20) not null,
weChat varchar(20) not null,
PRIMARY KEY (id)
)engine=innodb auto_increment=1 default charset=utf8 comment="用户表";

create table dog(
id int(11) not null auto_increment,
picture blob not null,
name varchar(8) not null,
age int(11) not null,
sex int(11) not null,
weight int(11) not null,
height int(11) not null,
life int(11) not null,
vaccine varchar(50) not null,
kind varchar(20) not null,
area varchar(50) not null,
seller_id int(11) not null,
PRIMARY KEY (id),
foreign key (seller_id) references user (id)
)engine=innodb auto_increment=1 default charset=utf8 comment="宠物狗表";

create table  dogknowleage(
id int(11) not null auto_increment,
picture blob not null,
name varchar(8) not null,
introduction text not null,
feed text not null,
treatment text not null,
trainning text not null,
PRIMARY KEY (id)
)engine=innodb auto_increment=1 default charset=utf8 comment="狗狗百科";

create table dogorder(
id int(11) not null auto_increment,
number varchar(20) not null ,
deliver_way varchar(10) not null,
deliver_price int(11) not null,
counts int(11) not null,
sumprice int(11) not null,
pay_way varchar(10) not null,
create_date TIMESTAMP not null default CURRENT_TIMESTAMP ,
status varchar(10) not null,
buyer_id int(11) not null,
seller_id int(11) not null,
PRIMARY KEY (id),
foreign key (buyer_id) references user (id),
foreign key (seller_id) references user (id)
)engine=innodb auto_increment=1 default charset=utf8 comment="订单表";

create table address(
id int(11) not null auto_increment,
buyer_id int(11) not null,
area varchar(10) not null,
datail varchar(50) not null,
tel varchar(11) not null,
dogorder_id int(11) not null,
PRIMARY KEY (id),
foreign key (buyer_id) references user (id)
)engine=innodb auto_increment=1 default charset=utf8 comment="收货地址表";

create table complaint(
id int(11) not null auto_increment,
complain_date TIMESTAMP  not null default CURRENT_TIMESTAMP ,
content text not null,
dogorder_id int(11) not null,
PRIMARY KEY (id),
foreign key (dogorder_id) references dogorder (id)
)engine=innodb auto_increment=1 default charset=utf8 comment="投诉表";
ALTER TABLE address DROP foreign key(dogorder_id) references dogorder(id);