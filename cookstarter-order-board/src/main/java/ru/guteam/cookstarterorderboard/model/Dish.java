package ru.guteam.cookstarterorderboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String name;
    private Integer qty;
    private BigInteger price;
}
