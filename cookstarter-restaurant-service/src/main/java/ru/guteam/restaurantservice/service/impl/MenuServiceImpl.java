package ru.guteam.restaurantservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guteam.restaurantservice.dto.DishDTO;
import ru.guteam.restaurantservice.dto.MenuDTO;
import ru.guteam.restaurantservice.exception.GetMenuException;
import ru.guteam.restaurantservice.model.Dish;
import ru.guteam.restaurantservice.repo.DishRepo;
import ru.guteam.restaurantservice.service.MenuService;
import ru.guteam.restaurantservice.util.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final DishRepo dishRepo;
    private final Mapper mapper;

    @Override
    @Transactional
    public void createMenu(MenuDTO menu) {
        dishRepo.saveAll(menu.getDishes());
    }

    @Override
    @Transactional
    public List<DishDTO> getMenu(Long restaurantId) {
        List<Dish> dishes = dishRepo.findAllByRestaurantId(restaurantId)
                .orElseThrow(() -> new GetMenuException(restaurantId));
        return dishes.stream().map(dish -> mapper.mapToDishDTO(dish)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteMenuByRestaurantId(Long restaurantId) {
        dishRepo.deleteAllByRestaurantId(restaurantId);
    }
}
