package com.grzywacz.traveloffice.user;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
import com.grzywacz.traveloffice.BasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class User extends BasicEntity {
    private String username;
    private String password;
    private Boolean enabled;
    @Column(name= "last_login_date")
    private LocalDate lastLoginDate;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Authority> authorities;

}