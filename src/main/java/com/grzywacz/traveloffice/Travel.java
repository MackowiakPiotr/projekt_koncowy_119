package com.grzywacz.traveloffice;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@Getter
@Setter
@ToString
public class Travel extends BasicEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "from_city_id")
    private City fromCity;
    @ManyToOne
    @JoinColumn(name = "from_airport_id")
    private Airport fromAirport;
    @ManyToOne
    @JoinColumn(name = "to_city_id")
    private City toCity;
    @ManyToOne
    @JoinColumn(name = "to_hotel_id")
    private Hotel toHotel;
    @ManyToOne
    @JoinColumn(name = "to_airport_id")
    private Airport toAirport;

    @Column(name="date_from")
    private LocalDate dateFrom;
    @Column(name = "date_to")
    private LocalDate dateTo;

    private int days;
    @Enumerated(EnumType.STRING)
    private HotelType hotelType;
    @Column(name = "adult_price")
    private Double adultPrice;

    @Column(name = "kid_price")
    private Double kidPrice;
    private boolean promoted;
    @Column(name = "available_slots_for_adults")
    private int availableSlotsForAdults;

    @Column(name = "available_slots_for_kids")
    private int availableSlotsForKids;

    private String description;
}
