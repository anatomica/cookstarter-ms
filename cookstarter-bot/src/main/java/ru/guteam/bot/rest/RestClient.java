package ru.guteam.bot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestClient {
    private final RestTemplate restTemplate;

    @Autowired
    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String getToken(String username, String password) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.set("username", username);
        form.set("password", password);

        ResponseEntity<String> tokenResponse = restTemplate.postForEntity("/auth",
                                                    new HttpEntity<>(form, new HttpHeaders()),
                                                    String.class);

        String token = tokenResponse.getHeaders().get("Authorization").get(0);

        return token;
    }
}
