package ru.guteam.restaurantservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guteam.restaurantservice.dto.DishDTO;
import ru.guteam.restaurantservice.exception.DishNotFountException;
import ru.guteam.restaurantservice.model.Dish;
import ru.guteam.restaurantservice.repo.DishRepo;
import ru.guteam.restaurantservice.util.Mapper;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepo dishRepo;
    private final Mapper mapper;


    @Override
    @Transactional
    public void saveDish(DishDTO dish) {
        dishRepo.save(mapper.mapToDish(dish));
    }

    @Override
    @Transactional
    public void updateDish(DishDTO dish) {
        Dish oldDish = dishRepo.findByNameAndRestaurantId(dish.getName(), dish.getRestaurantId())
                .orElseThrow(() -> new DishNotFountException(dish.getName(), dish.getRestaurantId()));
        Dish newDish = mapper.mapToDish(dish);
        newDish.setId(oldDish.getId());
        dishRepo.save(newDish);
    }

    @Override
    @Transactional
    public void deleteDish(DishDTO dish) {
        dishRepo.deleteByNameAndRestaurantId(dish.getName(), dish.getRestaurantId());
    }
}
