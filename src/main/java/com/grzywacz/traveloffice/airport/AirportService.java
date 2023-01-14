package com.grzywacz.traveloffice.airport;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grzywacz.traveloffice.city.City;
import com.grzywacz.traveloffice.city.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    private final CityRepository cityRepository;

    public AirportService(AirportRepository airportRepository, CityRepository cityRepository) {
        this.airportRepository = airportRepository;
        this.cityRepository = cityRepository;
    }


    public List<AirportDto> getAirports() {
        List<AirportDto> collect = airportRepository.findAll()
                                                .stream()
                                                .map(it -> new AirportDto(it.getId(), it.getName(), it.getCity().getId(), it.getCity().getName()))
                                                .collect(Collectors.toList());
        return collect;
    }

    public void addAirport(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setName(airportDto.getName());
        Optional<City> byId = cityRepository.findById(airportDto.getCityId());
        byId.ifPresent(it -> {
            airport.setCity(byId.get());
            airportRepository.save(airport);
        });
    }
    public void deleteById(long id){
        airportRepository.deleteById(id);
    }
}
