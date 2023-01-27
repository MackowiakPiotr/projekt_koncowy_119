package com.grzywacz.traveloffice.reservtion;

import java.util.List;

import com.grzywacz.traveloffice.travel.SimpleParticipantDto;
import lombok.Data;

@Data
public class TravelReservationDto {
    List<SimpleParticipantDto> simpleParticipantDtos;
    String buyerFirstName;
    String buyerLastName;
    String buyerPhone;
    String buyerEmail;
    double cost;
}
