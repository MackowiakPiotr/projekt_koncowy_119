package com.grzywacz.traveloffice;

import java.util.Set;

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
