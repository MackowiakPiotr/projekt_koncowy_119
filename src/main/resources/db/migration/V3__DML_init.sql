INSERT INTO `travel`
(`adult_price`,`available_slots_for_adults`,`available_slots_for_kids`,`date_from`,
 `date_to`,`days`,`hotel_type`,`kid_price`,`promoted`,`from_airport_id`,`from_city_id`,
 `to_airport_id`,`to_city_id`,`to_hotel_id`,`description`,`name`)
VALUES
    (2300,6,0,'2023-03-05','2023-03-15',0,'BB',null,1,
    (select id from airport where name='Modlin Airport'),
    (select id from city where name='Warsaw'),
    (select id from airport where name='RomeAirport II'),
    (select id from city where name='Rome'),
    (select id from hotel where name='Rome Hotel III'),
    'Wycieczka','Włochy 2023');