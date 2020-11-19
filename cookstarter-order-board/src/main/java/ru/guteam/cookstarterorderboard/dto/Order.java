package ru.guteam.cookstarterorderboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.guteam.cookstarterorderboard.model.Dish;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long restaurantId;
    private Long orderId;
    private String userName;
    private List<Dish> dishes;
}
