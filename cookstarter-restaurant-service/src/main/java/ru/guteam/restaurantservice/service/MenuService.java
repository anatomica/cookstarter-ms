package ru.guteam.restaurantservice.service;

import ru.guteam.restaurantservice.dto.Menu;
import ru.guteam.restaurantservice.model.Dish;

import java.util.List;

public interface MenuService {
    void createMenu(Menu menu);

    List<Dish> getMenu(Long restaurant_id);

}
