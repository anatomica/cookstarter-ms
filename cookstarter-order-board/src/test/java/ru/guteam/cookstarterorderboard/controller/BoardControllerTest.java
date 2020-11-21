package ru.guteam.cookstarterorderboard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.guteam.cookstarterorderboard.controller.util.Token.TOKEN;
import static ru.guteam.cookstarterorderboard.controller.util.Url.*;
import static ru.guteam.cookstarterorderboard.controller.util.Url.GET_BOARD;
import static ru.guteam.cookstarterorderboard.util.RequestHeaders.JWT_HEADER;

@WebMvcTest(BoardController.class)
public class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenRestaurantId_whenGetBoard_thenStatusOk() throws Exception {
        Long restaurantId = 1l;

        mockMvc.perform(
                get(GET_BOARD + restaurantId)
                        .header(JWT_HEADER, objectMapper.writeValueAsString(TOKEN)))
                .andExpect(status().isOk());
    }

}
