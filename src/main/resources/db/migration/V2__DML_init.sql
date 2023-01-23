
insert into continent(name) values ('Europe');
insert into continent(name) values ('Asia');
insert into continent(name) values ('Africa');

insert into country(name, continent_id) values ('Italy', (select id from continent where name='Europe'));
insert into country(name, continent_id) values ('Greece',(select id from continent where name='Europe'));
insert into country(name, continent_id) values ('Spain',(select id from continent where name='Europe'));
insert into country(name, continent_id) values ('Poland',(select id from continent where name='Europe'));

insert into city(name, country_id) values ("Rome", (select id from country where name='Italy'));
insert into city(name, country_id) values ("Neapol", (select id from country where name='Italy'));
insert into city(name, country_id) values ("Venice", (select id from country where name='Italy'));
insert into city(name, country_id) values ("Florence", (select id from country where name='Italy'));
insert into city(name, country_id) values ("Warsaw", (select id from country where name='Poland'));


insert into airport (name, city_id) values("RomeAirport I",(select id from city where name='Rome'));
insert into airport (name, city_id) values("RomeAirport II",(select id from city where name='Rome'));
insert into airport (name, city_id) values("NeapolAirport I",(select id from city where name='Neapol'));
insert into airport (name, city_id) values("Modlin Airport",(select id from city where name='Warsaw'));
insert into airport (name, city_id) values("Okęcie Airport",(select id from city where name='Warsaw'));

insert into hotel (description, name, starts, city_id) values("","Rome Hotel I", 'THREE', (select id from city where name='Rome'));
insert into hotel (description, name, starts, city_id) values("","Rome Hotel II", 'FOUR', (select id from city where name='Rome'));
insert into hotel (description, name, starts, city_id) values("","Rome Hotel III", 'FIVE', (select id from city where name='Rome'));