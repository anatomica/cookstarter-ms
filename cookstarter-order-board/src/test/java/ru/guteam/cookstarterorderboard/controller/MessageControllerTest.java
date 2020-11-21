package ru.guteam.cookstarterorderboard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.test.web.servlet.MockMvc;
import ru.guteam.cookstarterorderboard.dto.Order;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.guteam.cookstarterorderboard.controller.util.Token.TOKEN;
import static ru.guteam.cookstarterorderboard.controller.util.Url.*;
import static ru.guteam.cookstarterorderboard.controller.util.Url.ADD_ORDER;
import static ru.guteam.cookstarterorderboard.util.RequestHeaders.JWT_HEADER;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private SimpMessageSendingOperations simpMessageSendingOperations;


    @Test
    public void givenRestaurantId_whenGetBoard_thenStatusOk() throws Exception {
        Order order = new Order();

        mockMvc.perform(
                post(ADD_ORDER)
                        .header(JWT_HEADER, objectMapper.writeValueAsString(TOKEN))
                        .content(objectMapper.writeValueAsString(order))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
