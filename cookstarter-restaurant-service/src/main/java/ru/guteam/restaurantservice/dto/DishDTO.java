package ru.guteam.restaurantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    @NotNull
    private String name;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    private String description;
    private Long pictureId;
    @NotNull
    private Long restaurantId;
}
