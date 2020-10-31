package ru.guteam.restaurantservice.service;

import ru.guteam.restaurantservice.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant getRestaurant(Long id);
    Long saveRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurantsByName(String name);
    List<Restaurant> getRestaurantsByAddress(String address);
    //some method for many restaurants
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(Long id);
}
