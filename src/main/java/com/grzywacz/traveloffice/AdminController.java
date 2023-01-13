package com.grzywacz.traveloffice;

import java.util.Arrays;
import java.util.List;

import com.grzywacz.traveloffice.airport.AirportDto;
import com.grzywacz.traveloffice.airport.AirportRepository;
import com.grzywacz.traveloffice.airport.AirportService;
import com.grzywacz.traveloffice.city.CityDto;
import com.grzywacz.traveloffice.city.CityRepository;
import com.grzywacz.traveloffice.city.CityService;
import com.grzywacz.traveloffice.continent.ContinentDto;
import com.grzywacz.traveloffice.continent.ContinentService;
import com.grzywacz.traveloffice.country.CountryDto;
import com.grzywacz.traveloffice.country.CountryService;
import com.grzywacz.traveloffice.hotels.HotelDto;
import com.grzywacz.traveloffice.hotels.HotelRepository;
import com.grzywacz.traveloffice.hotels.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TravelService travelService;

    @Autowired
    private ContinentService continentService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private AirportService airportService;

    @GetMapping
    public String travels(Model model) {
        List<TravelDto> travels = travelService.getTravels();
        model.addAttribute("travels", travels);
        return "admin/travels";
    }

    @PostMapping("/travel/delete/{id}")
    public String delete(Model model, @PathVariable long id ) {
        travelService.delete(id);
        return "redirect:/admin/travels";
    }

    @GetMapping("/travel/add")
    public String showSignUpForm(Model model) {
        model.addAttribute("createTravel", new CreateTravelDto());
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("hotelTypes", Arrays.stream(HotelType.values()).toList());
        return "add-travel";
    }

    @GetMapping("/travel/edit/{id}")
    public String travelEdit(Model model, @PathVariable long id ) {
        TravelDto travel = travelService.getTravelById(id);
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("travel", travel);
        return "admin/edit-travel";
    }

    @PostMapping(value = "/travel/add")
    public String postBody(@ModelAttribute CreateTravelDto createTravelDto, Model model) {
        travelService.createTravel(createTravelDto);
        return "redirect:/admin/travels";
    }

    @GetMapping("/continents")
    public String continents(Model model) {
        List<ContinentDto> continents = continentService.getContinents();
        model.addAttribute("continents", continents);
        model.addAttribute("newContinent", new ContinentDto());
        return "admin/continents";
    }

    @PostMapping("/continents/add")
    public String addContinent(Model model,@ModelAttribute ContinentDto continentDto) {
        continentService.addContinent(continentDto);
        return "redirect:/admin/continents";
    }

    @PostMapping("/continents/delete/{id}")
    public String deleteContinent(Model model, @PathVariable long id ) {
        continentService.deleteById(id);
        return "redirect:/admin/continents";
    }

    @GetMapping("/countries")
    public String countries(Model model) {
        List<ContinentDto> continents = continentService.getContinents();
        List<CountryDto> countries = countryService.getCountries();
        model.addAttribute("continents", continents);
        model.addAttribute("countries", countries);
        model.addAttribute("newCountry", new CountryDto());
        return "admin/countries";
    }

    @PostMapping("/countries/delete/{id}")
    public String deleteCountry(Model model, @PathVariable long id ) {
        countryService.deleteById(id);
        return "redirect:/admin/countries";
    }

    @PostMapping("/country/add")
    public String addCountry(Model model,@ModelAttribute CountryDto countryDto) {
      //  continentService.addContinent(continentDto);
        countryService.addCountry(countryDto);
        return "redirect:/admin/countries";
    }

    @GetMapping("/cities")
    public String cities(Model model) {
        List<CountryDto> countries = countryService.getCountries();
        List<CityDto> cities = cityService.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("countries", countries);
        model.addAttribute("newCity", new CityDto());
        return "admin/cities";
    }

    @PostMapping("/city/add")
    public String addCity(Model model,@ModelAttribute CityDto cityDto) {
        //  continentService.addContinent(continentDto);
        cityService.addCity(cityDto);
        return "redirect:/admin/cities";
    }

    @PostMapping("/city/delete/{id}")
    public String deleteCity(Model model, @PathVariable long id ) {
        cityService.deleteById(id);
        return "redirect:/admin/cities";
    }

    @GetMapping("/hotels")
    public String hotels(Model model) {
        List<HotelDto> hotels = hotelService.getHotels();
        List<CityDto> cities = cityService.getCities();
        model.addAttribute("hotels", hotels);
        model.addAttribute("cities", cities);
        model.addAttribute("newHotel", new HotelDto());
        return "admin/hotels";
    }

    @PostMapping("/hotel/add")
    public String addHotel(Model model,@ModelAttribute HotelDto hotelDto) {
        hotelService.addHotel(hotelDto);
        return "redirect:/admin/hotels";
    }

    @PostMapping("/hotel/delete/{id}")
    public String deleteHotel(Model model, @PathVariable long id ) {
        hotelService.deleteById(id);
        return "redirect:/admin/hotels";
    }

    @GetMapping("/airports")
    public String airports(Model model) {
        List<AirportDto> airports = airportService.getAirports();
        List<CityDto> cities = cityService.getCities();
        model.addAttribute("airports", airports);
        model.addAttribute("cities", cities);
        model.addAttribute("newAirport", new AirportDto());
        return "admin/airports";
    }

    @PostMapping("/airport/add")
    public String addAirport(Model model,@ModelAttribute AirportDto airportDto) {
        airportService.addAirport(airportDto);
        return "redirect:/admin/airports";
    }

    @PostMapping("/airport/delete/{id}")
    public String deleteAirport(Model model, @PathVariable long id ) {
        airportService.deleteById(id);
        return "redirect:/admin/airports";
    }
}
