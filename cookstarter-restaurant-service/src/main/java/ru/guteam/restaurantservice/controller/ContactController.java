package ru.guteam.restaurantservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.guteam.restaurantservice.model.Contact;
import ru.guteam.restaurantservice.service.ContactService;

import static org.springframework.http.HttpStatus.OK;
import static ru.guteam.restaurantservice.controller.util.ResponseBuilder.contactAndStatus;
import static ru.guteam.restaurantservice.controller.util.ResponseBuilder.status;
import static ru.guteam.restaurantservice.util.RequestHeaders.JWT_HEADER;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addContact(@RequestHeader(JWT_HEADER) String token,
                                                 @RequestBody Contact contact) {
        contactService.saveContact(contact);
        return status(OK);
    }

    @CrossOrigin
    @GetMapping("/get/{restaurantId}")
    public ResponseEntity<Contact> getContact(@RequestHeader(JWT_HEADER) String token,
                                              @PathVariable Long restaurantId) {
        Contact contact = contactService.getContactByRestaurantId(restaurantId);
        return contactAndStatus(contact, OK);
    }

    @CrossOrigin
    @PostMapping("update/{restaurantId}")
    public ResponseEntity<HttpStatus> updateContact(@RequestHeader(JWT_HEADER) String token,
                                                    @PathVariable Long restaurantId,
                                                    @RequestBody Contact contact) {
        contactService.updateContact(restaurantId, contact);
        return status(OK);
    }

    @CrossOrigin
    @GetMapping("/delete/{restaurantId}")
    public ResponseEntity<HttpStatus> deleteContact(@RequestHeader(JWT_HEADER) String token,
                                                    @PathVariable Long restaurantId) {
        contactService.deleteContactByRestaurantId(restaurantId);
        return status(OK);
    }
}
