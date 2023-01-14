package com.grzywacz.traveloffice.city;

import java.util.Set;

import com.grzywacz.traveloffice.BasicEntity;
import com.grzywacz.traveloffice.country.Country;
import com.grzywacz.traveloffice.hotels.Hotel;
import com.grzywacz.traveloffice.airport.Airport;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class City extends BasicEntity {
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Hotel> hotels;

    @OneToMany(mappedBy = "city")
    private Set<Airport> airports;
}
