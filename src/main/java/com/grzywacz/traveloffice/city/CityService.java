package com.grzywacz.traveloffice.city;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grzywacz.traveloffice.country.Country;
import com.grzywacz.traveloffice.country.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    private final CountryRepository countryRepository;

    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public List<CityDto> getCities() {
        List<CityDto> collect = cityRepository.findAll()
                                              .stream()
                                              .map(it -> new CityDto(it.getId(), it.getName(), it.getCountry().getId(), it.getCountry().getName()))
                                              .collect(Collectors.toList());
        return collect;
    }

    public void addCity(CityDto cityDto) {
        City city = new City();
        city.setName(cityDto.getName());
        Optional<Country> byId = countryRepository.findById(cityDto.getCountryId());
        byId.ifPresent(it -> {
            city.setCountry(byId.get());
            cityRepository.save(city);
        });
    }
    public void deleteById(long id){
        countryRepository.deleteById(id);
    }
}
