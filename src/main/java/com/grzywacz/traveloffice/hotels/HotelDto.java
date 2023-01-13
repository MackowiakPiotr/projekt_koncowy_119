package com.grzywacz.traveloffice.hotels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private long id;
    private String name;
    private long cityId;
    private String cityName;
    private int starts;
}
