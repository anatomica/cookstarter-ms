package ru.guteam.customer_service.controllers;
// https://sysout.ru/testirovanie-spring-boot-prilozheniya-s-testresttemplate/

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import ru.guteam.customer_service.controllers.utils.TokenRequest;
import ru.guteam.customer_service.controllers.utils.CustomerTokenResponse;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenUserAuthenticated_thenStatus200() {
        TokenRequest request = new TokenRequest();
        request.setUsername("100");
        request.setPassword("100");
        ResponseEntity<CustomerTokenResponse> response = restTemplate.postForEntity("/auth", new HttpEntity<>(request), CustomerTokenResponse.class);
        CustomerTokenResponse customerTokenResponse = response.getBody();
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(customerTokenResponse, is(instanceOf(CustomerTokenResponse.class)));
        assertThat(customerTokenResponse.getToken(), is(notNullValue()));

    }
}
