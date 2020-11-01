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
import ru.guteam.customer_service.controllers.utils.RestaurantTokenResponse;
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
    public void whenCustomerAuthenticated_thenStatus200() {
        TokenRequest request = new TokenRequest();
        request.setUsername("100");
        request.setPassword("100");
        ResponseEntity<CustomerTokenResponse> response = restTemplate.postForEntity("/auth", new HttpEntity<>(request), CustomerTokenResponse.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        CustomerTokenResponse customerResponse = response.getBody();
        assert response.getBody() != null;
        assertThat(customerResponse, is(instanceOf(CustomerTokenResponse.class)));
        assertThat(customerResponse.getToken(), is(notNullValue()));
        assertThat(customerResponse.getToken(), is(instanceOf(String.class)));
    }

    @Test
    public void whenRestaurantAuthenticated_thenStatus200() {
        TokenRequest request = new TokenRequest();
        request.setUsername("1");
        request.setPassword("100");
        ResponseEntity<RestaurantTokenResponse> response = restTemplate.postForEntity("/auth", new HttpEntity<>(request), RestaurantTokenResponse.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assert response.getBody() != null;
        assertThat(response.getBody(), is(instanceOf(RestaurantTokenResponse.class)));
        assertThat(response.getBody().getToken(), is(notNullValue()));
        assertThat(response.getBody().getToken(), is(instanceOf(String.class)));
        assertThat(response.getBody().getId(), is(notNullValue()));
        assertThat(response.getBody().getId(), is(instanceOf(Long.class)));
    }
}
