package com.grzywacz.traveloffice.country;

import com.grzywacz.traveloffice.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
