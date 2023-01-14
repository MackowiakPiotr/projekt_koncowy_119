package com.grzywacz.traveloffice.continent;

import java.util.Set;

import com.grzywacz.traveloffice.BasicEntity;
import com.grzywacz.traveloffice.country.Country;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@ToString
@Getter
@Setter
public class Continent extends BasicEntity {
    private String name;

    @OneToMany(mappedBy = "continent")
    private Set<Country> countries;
}
