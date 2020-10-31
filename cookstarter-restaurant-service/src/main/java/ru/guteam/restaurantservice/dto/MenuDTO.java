package ru.guteam.restaurantservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.guteam.restaurantservice.model.Dish;

import java.util.List;

@Data
@AllArgsConstructor
public class MenuDTO {
    private List<Dish> dishes;
}
