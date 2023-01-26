insert into country(name, continent_id) values ('France', (select id from continent where name='Europe'));
insert into country(name, continent_id) values ('Egypt', (select id from continent where name='Africa'));

insert into city(name, country_id) values ("Paris", (select id from country where name='Paris'));
insert into city(name, country_id) values ("Hurghada", (select id from country where name='Egypt'));
insert into city(name, country_id) values ("Marsa Alam", (select id from country where name='Egypt'));

insert into airport (name, city_id) values("ParisAirport I",(select id from city where name='Paris'));
insert into airport (name, city_id) values("HurghadaAirport I",(select id from city where name='Hurghada'));
insert into airport (name, city_id) values("MarsaAlamAirport I",(select id from city where name='Marsa Alam'));
insert into airport (name, city_id) values("MarsaAlamAirport III",(select id from city where name='Marsa Alam'));

insert into hotel (description, name, starts, city_id) values("","Paris Hotel I", 'THREE', (select id from city where name='Paris'));
insert into hotel (description, name, starts, city_id) values("","Hurghada Hotel II", 'FOUR', (select id from city where name='Hurghada'));
insert into hotel (description, name, starts, city_id) values("","Hurghada Hotel III", 'FIVE', (select id from city where name='Hurghada'));
insert into hotel (description, name, starts, city_id) values("","Marsa Alam Hotel III", 'FIVE', (select id from city where name='Marsa Alam'));
