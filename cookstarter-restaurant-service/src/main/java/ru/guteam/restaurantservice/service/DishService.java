package ru.guteam.restaurantservice.service;

import ru.guteam.restaurantservice.dto.DishDTO;
import ru.guteam.restaurantservice.model.Dish;

public interface DishService {
    Long saveDish(DishDTO dish);

    Long updateDish(DishDTO dish);

    Long deleteDish(DishDTO dish);
}
