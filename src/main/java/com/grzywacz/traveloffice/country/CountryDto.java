package com.grzywacz.traveloffice.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private long id;
    private String name;
    private long continentId;
    private String continentName;

}
