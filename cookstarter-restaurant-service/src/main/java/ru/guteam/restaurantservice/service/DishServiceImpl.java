package ru.guteam.restaurantservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guteam.restaurantservice.exception.DishNotFountException;
import ru.guteam.restaurantservice.model.Dish;
import ru.guteam.restaurantservice.repo.DishRepo;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepo dishRepo;


    @Override
    @Transactional
    public Long saveDish(Dish dish) {
        return dishRepo.save(dish).getId();
    }

    @Override
    @Transactional
    public Long updateDish(Dish dish) {
        Dish oldDish = dishRepo.findByNameAndRestaurantId(dish.getName(), dish.getRestaurantId())
                .orElseThrow(() -> new DishNotFountException(dish.getName(), dish.getRestaurantId()));
        dish.setId(oldDish.getId());
        saveDish(dish);
        return dish.getId();
    }

    @Override
    @Transactional
    public Long deleteDish(Dish dish) {
        Long id = dishRepo.findByNameAndRestaurantId(dish.getName(), dish.getRestaurantId())
                .orElseThrow(() -> new DishNotFountException(dish.getName(), dish.getRestaurantId()))
                .getId();
        dishRepo.deleteByNameAndRestaurantId(dish.getName(), dish.getRestaurantId());
        return id;
    }
}
