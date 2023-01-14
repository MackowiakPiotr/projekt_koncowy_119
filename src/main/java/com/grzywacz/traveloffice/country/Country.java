package com.grzywacz.traveloffice.country;

import java.util.Set;

import com.grzywacz.traveloffice.BasicEntity;
import com.grzywacz.traveloffice.continent.Continent;
import com.grzywacz.traveloffice.city.City;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table
@Entity
public class Country extends BasicEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @OneToMany(mappedBy = "country")
    private Set<City> cities;
}
