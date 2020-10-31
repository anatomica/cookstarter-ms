package ru.guteam.restaurantservice.exception;


public class DishNotFountException extends NotFountException {
    public DishNotFountException(String name, Long restaurantId) {
        super("Dish with name: '" + name + "' and restaurant id: '" + restaurantId + "' not found");
    }
}
