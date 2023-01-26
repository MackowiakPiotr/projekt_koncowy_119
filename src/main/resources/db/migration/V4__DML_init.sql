INSERT INTO `travel`
(`adult_price`,`available_slots_for_adults`,`available_slots_for_kids`,`date_from`,
 `date_to`,`days`,`hotel_type`,`kid_price`,`promoted`,`from_airport_id`,`from_city_id`,
 `to_airport_id`,`to_city_id`,`to_hotel_id`,`description`,`name`)
VALUES
    (2700,10,2,'2023-05-05','2023-05-15',0,'BB',1800,1,
    (select id from airport where name='Okęcie Airport'),
    (select id from city where name='Warsaw'),
    (select id from airport where name='RomeAirport I'),
    (select id from city where name='Rome'),
    (select id from hotel where name='Rome Hotel II'),
    'Zwiedzanie Rzymu i okolic','Rzym 2023');