package com.grzywacz.traveloffice.reservtion;


import java.util.*;

import com.grzywacz.traveloffice.travel.SimpleParticipantDto;
import com.grzywacz.traveloffice.travel.TravelDto;
import com.grzywacz.traveloffice.travel.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final TravelService travelService;

    private final ReservationService reservationService;

    public ReservationController(TravelService travelService, ReservationService reservationService) {
        this.travelService = travelService;
        this.reservationService = reservationService;
    }

    @GetMapping("/{travelId}")
    public String reserveView(Model model, @PathVariable long travelId) {
        TravelReservationDto travelReservationDto = new TravelReservationDto();
        travelReservationDto.simpleParticipantDtos = new ArrayList<>();
        TravelDto travelById = travelService.getTravelById(travelId);
        model.addAttribute("travelReservationDto", travelReservationDto);
        model.addAttribute("travel", travelById);
        return "reservation";
    }

    @PostMapping("/{travelId}")
    public String reservation(@ModelAttribute TravelReservationDto travelReservationDto, Model model, @RequestParam(value = "action", required = false) String action,  @PathVariable long travelId ){
        boolean delete = action != null && action.startsWith("delete");
        TravelDto travelById = travelService.getTravelById(travelId);
        if ( delete) {
            String substring = action.substring(6, 7);
            int i = Integer.parseInt(substring);
            SimpleParticipantDto simpleParticipantDto = travelReservationDto.simpleParticipantDtos.get(i);
            travelReservationDto.simpleParticipantDtos.remove(simpleParticipantDto);
            model.addAttribute("travelReservationDto", travelReservationDto);
            model.addAttribute("travel", travelById);
            return "reservation";
        } else if (action!= null && action.equals("save")) {
            reservationService.createReservation(travelReservationDto, travelId);
            return "summary";
        } else {
            if (travelReservationDto.simpleParticipantDtos == null) {
                travelReservationDto.simpleParticipantDtos = new ArrayList<>();
            }
            travelReservationDto.simpleParticipantDtos.add(new SimpleParticipantDto());

            model.addAttribute("travelReservationDto", travelReservationDto);
            model.addAttribute("travel", travelById);
            return "reservation";
        }

    }

}
