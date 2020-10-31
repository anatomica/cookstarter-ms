package ru.guteam.restaurantservice.service;

import ru.guteam.restaurantservice.model.Contact;

public interface ContactService {
    void saveContact(Contact contact);
    Contact getContactByRestaurantId(Long restaurant_id);
    void updateContact(Long restaurant_id, Contact contact);
    void deleteContactByRestaurantId(Long restaurant_id);

}
