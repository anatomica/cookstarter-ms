package ru.guteam.restaurantservice.service;

import ru.guteam.restaurantservice.model.Dish;

public interface DishService {
    Long saveDish(Dish dish);

    Long updateDish(Dish dish);

    Long deleteDish(Dish dish);
}
