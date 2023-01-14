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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/travel")
public class TravelController {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TravelService travelService;

    @GetMapping("/travel-details")
    public String travelDetails(Model model) {
        return "/travel-details";
    }
    @GetMapping("/details/{id}")
    public String search(Model model, @PathVariable long id) {

        //model.addAttribute("travels", filteredTravels);
        return "/trips";
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
        return "/trips";
    }

    @GetMapping("/travels")
    public String showTravels(Model model) {
        List<TravelDto> travels = travelService.getTravels();
        model.addAttribute("travels", travels);
        return "travels";
    }

    @GetMapping("/trips")
    public String showTrips(Model model) {
        List<TravelDto> travels = travelService.getTravels();
        model.addAttribute("travels", travels);
        return "trips";
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

}
