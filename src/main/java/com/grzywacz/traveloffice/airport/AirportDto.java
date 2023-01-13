package com.grzywacz.traveloffice.airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportDto {
    private long id;
    private String name;
    private long cityId;
    private String cityName;
}
