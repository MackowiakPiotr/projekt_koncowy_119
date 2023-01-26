INSERT INTO `travel`
(`adult_price`,`available_slots_for_adults`,`available_slots_for_kids`,`date_from`,
 `date_to`,`days`,`hotel_type`,`kid_price`,`promoted`,`from_airport_id`,`from_city_id`,
 `to_airport_id`,`to_city_id`,`to_hotel_id`,`description`,`name`)
VALUES
    (3100,20,10,'2023-06-07','2023-06-21',0,'HB',2300,1,
     (select id from airport where name='Modlin Airport'),
     (select id from city where name='Warsaw'),
     (select id from airport where name='ParisAirport I'),
     (select id from city where name='Paris'),
     (select id from hotel where name='Paris Hotel I'),
     'Zwiedzanie Paryża i okolic','Paryż 2023, filmowa Francja');

INSERT INTO `travel`
(`adult_price`,`available_slots_for_adults`,`available_slots_for_kids`,`date_from`,
 `date_to`,`days`,`hotel_type`,`kid_price`,`promoted`,`from_airport_id`,`from_city_id`,
 `to_airport_id`,`to_city_id`,`to_hotel_id`,`description`,`name`)
VALUES
    (2500,20,10,'2023-06-07','2023-06-21',0,'HB',2300,1,
     (select id from airport where name='Modlin Airport'),
     (select id from city where name='Warsaw'),
     (select id from airport where name='MarsaAlamAirport III'),
     (select id from city where name='Marsa Alam'),
     (select id from hotel where name='Marsa Alam Hotel III'),
     'Zwiedzanie Paryża i okolic','Marsa Alam 2023, piramidy');