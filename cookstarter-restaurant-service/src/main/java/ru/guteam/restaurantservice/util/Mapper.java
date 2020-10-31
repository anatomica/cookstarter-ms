package ru.guteam.restaurantservice.util;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.guteam.restaurantservice.dto.ContactDTO;
import ru.guteam.restaurantservice.dto.DishDTO;
import ru.guteam.restaurantservice.dto.RestaurantDTO;
import ru.guteam.restaurantservice.model.Contact;
import ru.guteam.restaurantservice.model.Dish;
import ru.guteam.restaurantservice.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class Mapper {
    private final ModelMapper modelMapper;

    public Restaurant mapToRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        modelMapper.map(restaurantDTO, restaurant);
        return restaurant;
    }

    public Dish mapToDish(DishDTO dishDTO) {
        Dish dish = new Dish();
        modelMapper.map(dishDTO, dish);
        return dish;
    }

    public Contact mapToContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        modelMapper.map(contactDTO, contact);
        return contact;
    }

    public ContactDTO mapToContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        modelMapper.map(contact, contactDTO);
        return contactDTO;
    }

}
