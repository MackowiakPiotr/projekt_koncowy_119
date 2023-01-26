package com.grzywacz.traveloffice.travel;

import lombok.Data;

@Data
public class SimpleParticipantDto {
    String firstName;
    String lastName;

    Boolean adult = true;

}
