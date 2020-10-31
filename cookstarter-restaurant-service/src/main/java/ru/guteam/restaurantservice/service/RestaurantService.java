package ru.guteam.restaurantservice.service;

import ru.guteam.restaurantservice.dto.RestaurantDTO;
import ru.guteam.restaurantservice.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant getRestaurant(Long id);

    Long saveRestaurant(RestaurantDTO restaurant);

    List<RestaurantDTO> getRestaurantsByName(String name);

    List<RestaurantDTO> getRestaurantsByAddress(String address);

    //some method for many restaurants
    void updateRestaurant(RestaurantDTO restaurant);

    void deleteRestaurant(Long id);
}
