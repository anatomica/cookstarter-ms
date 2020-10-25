package ru.guteam.restaurant_service.service;

import java.util.List;

import ru.guteam.restaurant_service.model.Restaurant;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

/**
 * Интерфейс реализующий CRUD операции.
 */
public interface RestaurantService {

    ResponseEntity<Restaurant> create(@NonNull Restaurant restaurant);

    ResponseEntity<List<Restaurant>> readAll();

    ResponseEntity<Restaurant> read(@NonNull Long id);

    ResponseEntity<Restaurant> update(@NonNull Restaurant restaurant);

    ResponseEntity<Restaurant> delete(@NonNull Long id);

}
