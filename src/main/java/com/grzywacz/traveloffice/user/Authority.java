package com.grzywacz.traveloffice.user;

import com.grzywacz.traveloffice.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Authority extends BasicEntity {
    private String authority;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}