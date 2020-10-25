package ru.guteam.restaurant_service.controller;


import java.util.List;


import ru.guteam.restaurant_service.model.Restaurant;
import ru.guteam.restaurant_service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping(value = "/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant restaurant) {
        return restaurantService.create(restaurant);
    }

    @GetMapping(value = "/restaurants")
    public ResponseEntity<List<Restaurant>> readAll() {
        return restaurantService.readAll();
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable("id") Long id) {
        return restaurantService.read(id);
    }

    @PostMapping("/restaurants/update")
    public ResponseEntity<Restaurant> updateestaurant( @RequestBody Restaurant restaurant) {
        return  restaurantService.update(restaurant);
    }

    @DeleteMapping(value = "/restaurants/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        return restaurantService.delete(id);
    }
}
