package com.grzywacz.traveloffice.reservtion;

import com.grzywacz.traveloffice.BasicEntity;
import com.grzywacz.traveloffice.travel.Travel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class TravelOrder extends BasicEntity {
    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;

    private String participants;

    private double sum;

    private String buyerEmail;

    private String buyerPhone;

    private String buyerFirstName;

    private String buyerLastName;
}
