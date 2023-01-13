package com.grzywacz.traveloffice.continent;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContinentDto {
    private long id;
    private String name;

    public ContinentDto(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
