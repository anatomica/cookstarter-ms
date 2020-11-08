package ru.guteam.picture_service.controller.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.guteam.cookstarter.api.dto.StatusResponse;

import static ru.guteam.cookstarter.api.enums.RequestStatus.ERROR;
import static ru.guteam.cookstarter.api.enums.RequestStatus.OK;

@UtilityClass
public class StatusResponseBuilder {

    public static ResponseEntity<StatusResponse> error(HttpStatus status, String message) {
        return ResponseEntity
                .status(status)
                .body(StatusResponse.builder()
                        .status(ERROR)
                        .error(message)
                        .build());
    }

    public static ResponseEntity<StatusResponse> error(HttpStatus status) {
        return error(status, null);
    }

    public static ResponseEntity<StatusResponse> ok() {
        return ResponseEntity.ok(StatusResponse.builder()
                .status(OK)
                .build());
    }

    public static ResponseEntity<StatusResponse> okWithId(String id) {
        return ResponseEntity.ok(StatusResponse.builder()
                .status(OK)
                .id(id)
                .build());
    }
}
