package com.grzywacz.traveloffice.hotels;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grzywacz.traveloffice.City;
import com.grzywacz.traveloffice.Country;
import com.grzywacz.traveloffice.Hotel;
import com.grzywacz.traveloffice.Star;
import com.grzywacz.traveloffice.city.CityDto;
import com.grzywacz.traveloffice.city.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    private final CityRepository cityRepository;

    public HotelService(HotelRepository hotelRepository, CityRepository cityRepository) {
        this.hotelRepository = hotelRepository;
        this.cityRepository = cityRepository;
    }


    public List<HotelDto> getHotels() {
        List<HotelDto> collect = hotelRepository.findAll()
                                              .stream()
                                              .map(it -> new HotelDto(it.getId(), it.getName(), it.getCity().getId(), it.getCity().getName(), it.getStarts().label))
                                              .collect(Collectors.toList());
        return collect;
    }

    public void addHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDto.getName());
        Star startByLabel = Star.getStartByLabel(hotelDto.getStarts());
        hotel.setStarts(startByLabel);
        Optional<City> byId = cityRepository.findById(hotelDto.getCityId());
        byId.ifPresent(it -> {
            hotel.setCity(byId.get());
            hotelRepository.save(hotel);
        });
    }
    public void deleteById(long id){
        hotelRepository.deleteById(id);
    }
}
