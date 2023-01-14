package com.grzywacz.traveloffice.hotels;

import com.grzywacz.traveloffice.BasicEntity;
import com.grzywacz.traveloffice.city.City;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class Hotel extends BasicEntity {
    private String name;
    @Enumerated(EnumType.STRING)
    private Star starts;

    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
