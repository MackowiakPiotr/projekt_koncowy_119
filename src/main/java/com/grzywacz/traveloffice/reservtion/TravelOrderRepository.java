package com.grzywacz.traveloffice.reservtion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelOrderRepository extends JpaRepository<TravelOrder, Long> {
}
