CREATE TABLE `continent` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_polish_ci;

CREATE TABLE `country` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `continent_id` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKpymfsgrl32dy3gtl9r7rykkjg` (`continent_id`),
   CONSTRAINT `FKpymfsgrl32dy3gtl9r7rykkjg` FOREIGN KEY (`continent_id`) REFERENCES `continent` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_polish_ci;

CREATE TABLE `city` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `country_id` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKrpd7j1p7yxr784adkx4pyepba` (`country_id`),
    CONSTRAINT `FKrpd7j1p7yxr784adkx4pyepba` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_polish_ci;

CREATE TABLE `airport` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `city_id` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKf583ieaw0ttnwklqy222tfru0` (`city_id`),
    CONSTRAINT `FKf583ieaw0ttnwklqy222tfru0` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_polish_ci;

CREATE TABLE `hotel` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `description` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `name` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `starts` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `city_id` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKf1iabdv6bi2yohh9h48wce42x` (`city_id`),
    CONSTRAINT `FKf1iabdv6bi2yohh9h48wce42x` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_polish_ci;


CREATE TABLE `travel` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `adult_price` double DEFAULT NULL,
    `available_slots_for_adults` int DEFAULT NULL,
    `available_slots_for_kids` int DEFAULT NULL,
    `date_from` date DEFAULT NULL,
    `date_to` date DEFAULT NULL,
    `days` int NOT NULL,
    `hotel_type` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `kid_price` double DEFAULT NULL,
    `promoted` bit(1) NOT NULL,
    `from_airport_id` bigint DEFAULT NULL,
    `from_city_id` bigint DEFAULT NULL,
    `to_airport_id` bigint DEFAULT NULL,
    `to_city_id` bigint DEFAULT NULL,
    `to_hotel_id` bigint DEFAULT NULL,
    `description` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `name` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK67tipp9qmg60atdqh4s2f1291` (`from_city_id`),
    KEY `FKija7vvivqij206vq35n4ucgf` (`to_airport_id`),
    KEY `FKcaqub3bydym76i5xn66w4obyp` (`to_city_id`),
    KEY `FKq7v78lewc0diui0x682x381cx` (`to_hotel_id`),
    KEY `FKlaf828smr55l94ggvch4wwmg3` (`from_airport_id`),
    CONSTRAINT `FK67tipp9qmg60atdqh4s2f1291` FOREIGN KEY (`from_city_id`) REFERENCES `city` (`id`),
    CONSTRAINT `FKcaqub3bydym76i5xn66w4obyp` FOREIGN KEY (`to_city_id`) REFERENCES `city` (`id`),
    CONSTRAINT `FKija7vvivqij206vq35n4ucgf` FOREIGN KEY (`to_airport_id`) REFERENCES `airport` (`id`),
    CONSTRAINT `FKlaf828smr55l94ggvch4wwmg3` FOREIGN KEY (`from_airport_id`) REFERENCES `airport` (`id`),
    CONSTRAINT `FKq7v78lewc0diui0x682x381cx` FOREIGN KEY (`to_hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_polish_ci;

CREATE TABLE `travel_order` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `participants` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `sum` double NOT NULL,
    `travel_id` bigint NOT NULL,
    `buyer_email` varchar(45) COLLATE utf8mb3_polish_ci NOT NULL,
    `buyer_phone` varchar(45) COLLATE utf8mb3_polish_ci NOT NULL,
    `buyer_first_name` varchar(45) COLLATE utf8mb3_polish_ci NOT NULL,
    `buyer_last_name` varchar(45) COLLATE utf8mb3_polish_ci NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKb9uv3h4phf34c2up5wmaa5kcm` (`travel_id`),
    CONSTRAINT `FKb9uv3h4phf34c2up5wmaa5kcm` FOREIGN KEY (`travel_id`) REFERENCES `travel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_polish_ci;

CREATE TABLE `user` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `username` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `password` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `enabled` BIT(1) COLLATE utf8mb3_polish_ci DEFAULT NULL,
    `last_login_date` date,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_polish_ci;

CREATE TABLE `authority` (
     `id` bigint NOT NULL AUTO_INCREMENT,
     `user_id` bigint not null,
     `authority` varchar(255) COLLATE utf8mb3_polish_ci DEFAULT NULL,
     PRIMARY KEY (`id`),
     FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_polish_ci;