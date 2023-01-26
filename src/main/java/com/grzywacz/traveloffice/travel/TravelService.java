package com.grzywacz.traveloffice.travel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grzywacz.traveloffice.airport.Airport;
import com.grzywacz.traveloffice.airport.AirportRepository;
import com.grzywacz.traveloffice.city.City;
import com.grzywacz.traveloffice.city.CityRepository;
import com.grzywacz.traveloffice.hotels.Hotel;
import com.grzywacz.traveloffice.hotels.HotelRepository;
import com.grzywacz.traveloffice.hotels.HotelType;
import org.springframework.stereotype.Service;

@Service
public class TravelService {

    private final CityRepository cityRepository;
    private final AirportRepository airportRepository;
    private final HotelRepository hotelRepository;
    private final TravelRepository travelRepository;

    public TravelService(CityRepository cityRepository, AirportRepository airportRepository, HotelRepository hotelRepository, TravelRepository travelRepository) {
        this.cityRepository = cityRepository;
        this.airportRepository = airportRepository;
        this.hotelRepository = hotelRepository;
        this.travelRepository = travelRepository;
    }

    public List<TravelDto> getTravels() {
        List<Travel> all = travelRepository.findAllOrderByDateFromDesc();
        return all.stream()
                  .map(it -> {
                      TravelDto travelDto = new TravelDto(it.getId(), it.getName(), it.getDescription(), it.getDateFrom(), it.getDateTo(), it.getFromCity().getName(), it.getToCity().getName(),
                                    it.isPromoted());
                      travelDto.setAdultPrice(it.getAdultPrice());
                      return travelDto;
                  })
                  .limit(5)
                  .collect(Collectors.toList());
    }

    public TravelDto getTravelById(long id) {
        Optional<Travel> byId = travelRepository.findById(id);

        TravelDto travelDto = new TravelDto();
        byId.ifPresent(it -> {
            travelDto.setId(it.getId());
            travelDto.setName(it.getName());
            travelDto.setDescription(it.getDescription());
            travelDto.setFromCityId(it.getFromCity().getId());
            travelDto.setCityTo(it.getToCity().getName());
            travelDto.setCityFrom(it.getFromCity().getName());
            travelDto.setHotelName(it.getToHotel().getName());
            travelDto.setDateFrom(it.getDateFrom());
            travelDto.setDateTo(it.getDateTo());
            travelDto.setFromAirportName(it.getFromAirport().getName());
            travelDto.setDescription(it.getDescription());
            travelDto.setAdultPrice(it.getAdultPrice());
            travelDto.setKidPrice(it.getKidPrice());
        });
        return travelDto;
    }

    public void createTravel(CreateTravelDto createTravelDto) {
        Optional<City> fromCity = cityRepository.findById(createTravelDto.getFromCityId());
        Optional<Airport> fromAirport = airportRepository.findById(createTravelDto.getFromAirportId());
        Optional<City> toCity = cityRepository.findById(createTravelDto.getToCityId());
        Optional<Airport> toAirport = airportRepository.findById(createTravelDto.getToAirportId());
        Optional<Hotel> toHotel = hotelRepository.findById(createTravelDto.getToHotelId());

        Travel travel = new Travel();
        travel.setName(createTravelDto.getName());
        travel.setDescription(createTravelDto.getDescription());
        travel.setFromCity(fromCity.get());
        travel.setFromAirport(fromAirport.get());
        travel.setToCity(toCity.get());
        travel.setToAirport(toAirport.get());
        travel.setToHotel(toHotel.get());

        String[] split = createTravelDto.getDateFrom().split("/");
        LocalDate dateFrom = LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]));
        travel.setDateFrom(dateFrom);
        String[] splitDateTo = createTravelDto.getDateTo().split("/");
        LocalDate dateTo = LocalDate.of(Integer.parseInt(splitDateTo[2]), Integer.parseInt(splitDateTo[1]), Integer.parseInt(splitDateTo[0]));
        travel.setDateTo(dateTo);
        travel.setAdultPrice(createTravelDto.getAdultPrice());
        travel.setKidPrice(createTravelDto.getKidPrice());
        travel.setAvailableSlotsForAdults(createTravelDto.getAdultPlaces());
        travel.setAvailableSlotsForKids(createTravelDto.getKidPlaces());
        HotelType hotelType = HotelType.valueOf(createTravelDto.getHotelType());
        travel.setHotelType(hotelType);
        if (createTravelDto.getIsPromoted() == null) {
            travel.setPromoted(false);
        } else {
            travel.setPromoted(createTravelDto.getIsPromoted());
        }

        travelRepository.save(travel);
    }

    public void delete(long id) {
        travelRepository.deleteById(id);
    }
}
