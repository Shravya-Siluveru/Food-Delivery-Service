package com.ssiluveru.restaurantlisting.service;

import com.ssiluveru.restaurantlisting.dto.RestaurantDTO;
import com.ssiluveru.restaurantlisting.entity.Restaurant;
import com.ssiluveru.restaurantlisting.mapper.RestaurantMapper;
import com.ssiluveru.restaurantlisting.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> listAllRestaurants() {
        List<Restaurant> all = restaurantRepository.findAll();
        return all.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO).collect(Collectors.toList());
    }

    public RestaurantDTO addNewRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantRepository.save(restaurant));
    }

    public RestaurantDTO getByRestaurantId(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant.map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO).orElse(null);
    }

}
