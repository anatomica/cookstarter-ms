package ru.guteam.restaurantservice.util;

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
public class Mapper extends ModelMapper {

    public Restaurant mapToRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        map(restaurantDTO, restaurant);
        return restaurant;
    }

    public Dish mapToDish(DishDTO dishDTO) {
        Dish dish = new Dish();
        map(dishDTO, dish);
        return dish;
    }

    public Contact mapToContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        map(contactDTO, contact);
        return contact;
    }

    public ContactDTO mapToContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        map(contact, contactDTO);
        return contactDTO;
    }

    public List<RestaurantDTO> mapToRestaurantDTOList(List<Restaurant> restaurants) {
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            map(restaurant, restaurantDTO);
            restaurantDTOList.add(restaurantDTO);
        }
        return restaurantDTOList;
    }
}
