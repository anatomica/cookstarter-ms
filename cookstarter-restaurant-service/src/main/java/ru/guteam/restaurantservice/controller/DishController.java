package ru.guteam.restaurantservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.guteam.restaurantservice.dto.DishDTO;
import ru.guteam.restaurantservice.model.Dish;
import ru.guteam.restaurantservice.service.DishService;

import static org.springframework.http.HttpStatus.OK;
import static ru.guteam.restaurantservice.controller.util.ResponseBuilder.idAndStatus;
import static ru.guteam.restaurantservice.util.RequestHeaders.JWT_HEADER;

@RestController
@RequestMapping("/dish")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Long> addDish(@RequestHeader(JWT_HEADER) String token,
                                        @RequestBody DishDTO dish) {
        Long id = dishService.saveDish(dish);
        return idAndStatus(id, OK);
    }

    @CrossOrigin
    @PostMapping("/update")
    public ResponseEntity<Long> updateDish(@RequestHeader(JWT_HEADER) String token,
                                           @RequestBody DishDTO dish) {
        Long id = dishService.updateDish(dish);
        return idAndStatus(id, OK);
    }

    @CrossOrigin
    @GetMapping("/delete")
    public ResponseEntity<Long> deleteDish(@RequestHeader(JWT_HEADER) String token,
                                           @RequestBody DishDTO dish) {
        Long id = dishService.deleteDish(dish);
        return idAndStatus(id, OK);
    }

}
