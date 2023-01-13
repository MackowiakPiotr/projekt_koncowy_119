package com.grzywacz.traveloffice.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private long id;
    private String name;
    private long countryId;
    private String countryName;

}
