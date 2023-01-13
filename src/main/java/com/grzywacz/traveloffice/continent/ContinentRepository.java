package com.grzywacz.traveloffice.continent;

import com.grzywacz.traveloffice.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
