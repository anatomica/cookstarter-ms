package ru.guteam.restaurantservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.guteam.restaurantservice.dto.RestaurantDTO;
import ru.guteam.restaurantservice.model.Restaurant;
import ru.guteam.restaurantservice.service.RestaurantService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static ru.guteam.restaurantservice.controller.util.ResponseBuilder.*;
import static ru.guteam.restaurantservice.util.RequestHeaders.JWT_HEADER;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Long> addRestaurant(@RequestHeader(JWT_HEADER) String token,
                                              @RequestBody RestaurantDTO restaurant) {
        Long restaurantId = restaurantService.saveRestaurant(restaurant);
        return idAndStatus(restaurantId, OK);
    }

    @CrossOrigin
    @GetMapping("/getByName/{name}")
    public ResponseEntity<List> getRestaurantsByName(@RequestHeader(JWT_HEADER) String token,
                                                     @PathVariable String name) {
        List<Restaurant> restaurantsByName = restaurantService.getRestaurantsByName(name);
        return listAndStatus(restaurantsByName, OK);
    }

    @CrossOrigin
    @GetMapping("/getAll")
    public ResponseEntity<List> getRestaurantsByAddress(@RequestHeader(JWT_HEADER) String token) {
        List<Restaurant> restaurants = restaurantService.getAll();
        return listAndStatus(restaurants, OK);
    }

    @CrossOrigin
    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateRestaurant(@RequestHeader(JWT_HEADER) String token,
                                                       @RequestBody Restaurant restaurant) {
        restaurantService.updateRestaurant(restaurant);
        return status(OK);
    }

    @CrossOrigin
    @GetMapping("/delete/{id}")
    public ResponseEntity<Long> deleteRestaurant(@RequestHeader(JWT_HEADER) String token,
                                                 @PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return idAndStatus(id, OK);
    }


}
