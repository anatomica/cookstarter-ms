package ru.guteam.restaurant_service.service;


import java.util.List;

import ru.guteam.restaurant_service.model.Restaurant;
import ru.guteam.restaurant_service.repository.RestaurantRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceDB implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceDB(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public ResponseEntity<Restaurant> create(@NonNull Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Restaurant>> readAll() {
        List<Restaurant> restaurants =restaurantRepository.findAll();
        return restaurants != null &&  !restaurants.isEmpty()
                ? new ResponseEntity<>(restaurants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Restaurant> read(@NonNull Long id)  {
        return new ResponseEntity<Restaurant>(
                restaurantRepository.findById(id).get(),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Restaurant> update(@NonNull Restaurant restaurant) {
        Restaurant someRestaurant = restaurantRepository.findById(restaurant.getId()).get();
        if(someRestaurant != null){
            someRestaurant=restaurant;
            restaurantRepository.save(someRestaurant);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public ResponseEntity<Restaurant> delete(@NonNull Long id) {
        if(restaurantRepository.findById(id).isPresent()){
            restaurantRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
