package ru.guteam.restaurantservice.controller.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.guteam.restaurantservice.model.Contact;

import java.util.List;

@UtilityClass
public class ResponseBuilder {

    public ResponseEntity<Long> idAndStatus(Long id, HttpStatus status) {
        return ResponseEntity.status(status).body(id);
    }

    public ResponseEntity<List> listAndStatus(List list, HttpStatus status) {
        return ResponseEntity.status(status).body(list);
    }

    public ResponseEntity<Contact> contactAndStatus(Contact contact, HttpStatus status) {
        return ResponseEntity.status(status).body(contact);
    }

    public ResponseEntity<HttpStatus> status(HttpStatus status) {
        return ResponseEntity.status(status).build();
    }

    public ResponseEntity<String> error(String message, HttpStatus status) {
        return ResponseEntity.status(status).body(message);
    }

    public ResponseEntity<String> error(HttpStatus status) {
        return ResponseEntity.status(status).build();
    }


}
