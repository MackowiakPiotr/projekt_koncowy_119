package com.grzywacz.traveloffice.travel;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TravelDto {
    private long id;
    private String name;
    private String description;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String cityFrom;
    private String cityTo;

    private long fromCityId;
    private long fromAirportId;
    private long toCityId;
    private long toHotelId;
    private long toAirportId;

    private String hotelType;
    private Double adultPrice;
    private Double kidPrice;
    private Boolean isPromoted;

    private int adultPlaces;
    private int kidPlaces;

    public TravelDto() {
    }

    public TravelDto(long id, String name, String description, LocalDate dateFrom, LocalDate dateTo, String cityFrom, String cityTo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }
}
