package com.grzywacz.traveloffice.reservtion;

import java.util.List;
import java.util.Optional;

import com.grzywacz.traveloffice.travel.Travel;
import com.grzywacz.traveloffice.travel.TravelRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final TravelOrderRepository travelOrderRepository;
    private final TravelRepository travelRepository;
    public ReservationService(TravelOrderRepository travelOrderRepository, TravelRepository travelRepository) {
        this.travelOrderRepository = travelOrderRepository;
        this.travelRepository = travelRepository;
    }

    public void createReservation(TravelReservationDto travelReservationDto, long travelId) {
        Optional<Travel> byId = travelRepository.findById(travelId);
        byId.ifPresent(t -> {
            TravelOrder travelOrder = new TravelOrder();
            travelOrder.setTravel(t);
            travelOrder.setBuyerEmail(travelReservationDto.buyerEmail);
            travelOrder.setBuyerPhone(travelReservationDto.buyerPhone);
            travelOrder.setBuyerFirstName(travelReservationDto.buyerFirstName);
            travelOrder.setBuyerLastName(travelReservationDto.buyerLastName);
            List<String> strings = travelReservationDto.simpleParticipantDtos.stream().map(elem -> elem.getFirstName() + " " + elem.getLastName()).toList();
            String participants = String.join(",", strings);
            travelOrder.setParticipants(participants);
            travelOrderRepository.save(travelOrder);
        });

    }
}
