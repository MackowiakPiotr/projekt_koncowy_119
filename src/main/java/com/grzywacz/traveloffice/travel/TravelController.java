package com.grzywacz.traveloffice.travel;


import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.grzywacz.traveloffice.airport.Airport;
import com.grzywacz.traveloffice.airport.AirportRepository;
import com.grzywacz.traveloffice.city.City;
import com.grzywacz.traveloffice.city.CityRepository;
import com.grzywacz.traveloffice.hotels.Hotel;
import com.grzywacz.traveloffice.hotels.HotelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TravelController {
    private final TravelService travelService;

    private final CityRepository cityRepository;
    private final AirportRepository airportRepository;
    private final HotelRepository hotelRepository;

    public TravelController(TravelService travelService, CityRepository cityRepository, AirportRepository airportRepository, HotelRepository hotelRepository) {
        this.travelService = travelService;
        this.cityRepository = cityRepository;
        this.airportRepository = airportRepository;
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/home")
    public String showTravels(Model model) {
        List<TravelDto> travels = travelService.getTravels();
        List<TravelDto> promotingTravels = travels.stream().filter(TravelDto::getIsPromoted).toList();
        travels = travels.stream().limit(3).toList();

        model.addAttribute("travels", travels);
        model.addAttribute("promotingTravels", promotingTravels);
        return "travels";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(value = "cityFrom", required = false) String cityFrom,
                         @RequestParam(value = "cityTo", required = false) String cityTo,
                         @RequestParam(value = "dateFrom", required = false) String dateFrom,
                         @RequestParam(value = "dateTo", required = false) String dateTo) {
        List<TravelDto> filteredTravels = travelService.getTravels();
        if (cityFrom != null && !cityFrom.isEmpty()) {
            filteredTravels = filteredTravels.stream().filter(it -> it.getCityFrom().equals(cityFrom)).collect(Collectors.toList());
        }
        if (cityTo != null && !cityTo.isEmpty()) {
            filteredTravels = filteredTravels.stream().filter(it -> it.getCityTo().equals(cityTo)).collect(Collectors.toList());
        }
        model.addAttribute("travels", filteredTravels);
        model.addAttribute("cityTo", cityTo);
        model.addAttribute("cityFrom", cityFrom);
        return "search";
    }

    @GetMapping("/airport/{cityId}")
    @ResponseBody
    public String listProducts(@PathVariable long cityId) {
        Optional<City> byId = cityRepository.findById(cityId);
        List<Airport> all = this.airportRepository.findAll();
        Map<String, String> airports = new HashMap<>();
        all.stream().filter(p -> p.getCity().getName().equals(byId.get().getName())).forEach(p -> {
            airports.put(String.valueOf(p.getId()), p.getName());
        });
        return new Gson().toJson(airports);
    }

    @GetMapping("/hotel/{cityId}")
    @ResponseBody
    public String listHotels(@PathVariable long cityId) {
        Optional<City> byId = cityRepository.findById(cityId);
        List<Hotel> all = this.hotelRepository.findAll();
        Map<String, String> hotels = new HashMap<>();
        all.stream().filter(p -> p.getCity().getName().equals(byId.get().getName())).forEach(p -> {
            hotels.put(String.valueOf(p.getId()), p.getName());
        });
        return new Gson().toJson(hotels);
    }

    @GetMapping("/travel-details/{id}")
    public String travelDetails(Model model, @PathVariable long id) {
        TravelDto travelById = travelService.getTravelById(id);
        model.addAttribute("travel", travelById);
        return "/travel-details";
    }

}