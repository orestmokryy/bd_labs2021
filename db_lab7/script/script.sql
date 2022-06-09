create database if not exists family_db;
use family_db;

drop table if exists family_tree;
drop table if exists family_has_value;

drop table if exists family_values;
drop table if exists family_life_partners;
drop table if exists member_has_value;
drop table if exists sex;



create table family_tree (
    id int not null auto_increment PRIMARY KEY,
	surname varchar(45) not null,
    name varchar(45) not null,
	credit_card_number varchar(20) not null,
    birth_date date not null,
	birth_place varchar(45) not null,
    death_date date not null,
    death_place varchar(45) not null,
	sex_id int not null,
    tree_id int default null
);

create table family_life_partners (
    id int not null auto_increment PRIMARY KEY,
    surname varchar(45) not null,
	name varchar(45) not null,
    birth_date date not null,
    birth_place varchar(45) not null,
    death_date date not null,
    death_place varchar(45) not null,
    marriage_date date not null,
     tree_id int not null,
    sex_id int not null
);

create table family_values (
    id int not null auto_increment PRIMARY KEY,
    name varchar(45) not null,
    estimated_price int not null,
    max_price int not null,
    min_price int not null,
    catalog_code int not null
);

create table family_has_value (
	id int auto_increment PRIMARY KEY,
    family_tree_id  int not null,
    family_values_id int not null
);

create table sex (
    id int not null auto_increment PRIMARY KEY,
    name varchar(45) not null
);
insert into sex (name)
values
		('female'),
		('male');


insert into family_life_partners (surname, name, birth_date, birth_place, death_date, death_place,
						marriage_date, sex_id, tree_id)
values
		('Hell', 'Boi', '1990-01-01', ' HUT', '2070-01-01', 'random', '2025-01-01', 1,2),
        ('Lil', 'Database', '1990-01-01', ' Valley', '2070-01-02', 'palace ', '2020-01-01', 2,2),
        ('Mister', 'Gordon', '1990-01-01', 'Beach', '2030-01-01', 'shesesh', '2020-05-05', 2,2);


insert into family_tree (surname, name, credit_card_number, birth_date, birth_place, death_date,
						death_place, sex_id,  tree_id)
values
		('Diza', 'Lyduk', '1111 2222 3333 4444', '1990-01-01', ' Ship', '2010-01-01', 'Strilky', 1, 1),
		('Jackson', 'Michael','5555 6666 7777 8888', '1990-01-01', 'Hey', '2010-01-01', 'Strilky', 2, 1),
			('Jackson', 'Michael','5555 6666 7777 8888', '1990-01-01', 'Hey', '2010-01-01', 'Strilky', 2, 1),
        ('Jag', 'kaj', '9999 1010 1111 1212', '2029-01-01', 'Rancho', '2070-01-01', 'Yariw', 2, 1);

insert into family_values (name, estimated_price, max_price, min_price, catalog_code)
values
		('Nothing', 1000, 1200, 0, 3),
        ('Dvorez Putina', 8263789, 1500, 750, 2),
        ('Golden toilet', 500, 950, 300, 5);


insert into family_has_value (family_tree_id, family_values_id)
values
		(3, 1),
        (3, 1),
        (3, 2),
        (3, 3),
        (3, 3);