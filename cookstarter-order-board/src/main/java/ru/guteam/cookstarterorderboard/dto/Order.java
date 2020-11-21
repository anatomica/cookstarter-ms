package ru.guteam.cookstarterorderboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.guteam.cookstarterorderboard.model.Dish;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @NotNull
    private Long restaurantId;
    @NotNull
    private Long orderId;
    @NotNull
    private String userName;
    @NotNull
    private List<Dish> dishes;
}
