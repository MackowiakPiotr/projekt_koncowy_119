package com.grzywacz.traveloffice;

import java.util.Set;

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
