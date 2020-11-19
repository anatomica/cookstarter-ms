package ru.guteam.cookstarterorderboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;
import ru.guteam.cookstarterorderboard.dto.Order;

import static ru.guteam.cookstarterorderboard.util.RequestHeaders.*;

@RestController
public class MessageController {
    private final String TOPIC = "/topic/board/";
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    public MessageController(SimpMessageSendingOperations simpMessageSendingOperations) {
        this.simpMessageSendingOperations = simpMessageSendingOperations;
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addOrder(@RequestHeader(JWT_HEADER) String token,
                                               @RequestBody Order order) {
        simpMessageSendingOperations.convertAndSend(TOPIC + order.getRestaurantId(), order);
        return new ResponseEntity(HttpStatus.OK);
    }
}
