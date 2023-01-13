package com.grzywacz.traveloffice;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTravelDto {
    private String name;
    private String description;
    private long fromCityId;
    private long fromAirportId;
    private long toCityId;
    private long toHotelId;
    private long toAirportId;
    private String dateFrom;
    private String dateTo;
    private String hotelType;
    private Double adultPrice;
    private Double kidPrice;
    private Boolean isPromoted;

    private int adultPlaces;
    private int kidPlaces;

    public CreateTravelDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
