create database if not exists bikerzzone;
use bikerzzone;
create table bike(
id int not null auto_increment primary key,
brand varchar(100) not null,
model varchar(100) not null unique,
price double not null,
ownership varchar(100) not null,
location varchar(100),
manufactureDate date not null
);
drop table bike;

select * from bike;
truncate bike;

-- SELECT * FROM bike WHERE brand = "hero"; 
