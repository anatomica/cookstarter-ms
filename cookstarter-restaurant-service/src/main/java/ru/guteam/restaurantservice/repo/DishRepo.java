package ru.guteam.restaurantservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.guteam.restaurantservice.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepo extends JpaRepository<Dish, Long> {

    Optional<Dish> findByNameAndRestaurantId(String name, Long restaurant_id);

    void deleteByNameAndRestaurantId(String name, Long restaurantId);

    Optional<List<Dish>> findAllByRestaurantId(Long restaurantId);

    void deleteAllByRestaurantId(Long restaurantId);
}
