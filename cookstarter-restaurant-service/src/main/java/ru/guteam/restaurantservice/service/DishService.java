package ru.guteam.restaurantservice.service;

import ru.guteam.restaurantservice.dto.DishDTO;
import ru.guteam.restaurantservice.model.Dish;

public interface DishService {
    void saveDish(DishDTO dish);

    void updateDish(DishDTO dish);

    void deleteDish(DishDTO dish);
}
