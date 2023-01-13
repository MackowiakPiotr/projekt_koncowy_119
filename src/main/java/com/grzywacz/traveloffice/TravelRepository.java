package com.grzywacz.traveloffice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
    @Query("SELECT t FROM Travel t order by t.dateFrom desc")
    List<Travel> findAllOrderByDateFromDesc();
}
