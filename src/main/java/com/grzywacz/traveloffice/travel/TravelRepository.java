package com.grzywacz.traveloffice.travel;

import java.util.List;

import com.grzywacz.traveloffice.travel.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
    @Query("SELECT t FROM Travel t order by t.dateFrom desc")
    List<Travel> findAllOrderByDateFromDesc();
}
