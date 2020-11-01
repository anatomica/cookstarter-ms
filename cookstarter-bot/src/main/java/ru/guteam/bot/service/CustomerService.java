package ru.guteam.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.guteam.bot.rest.RestClient;
import ru.guteam.bot.sender.CustomerSender;

@Service
public class CustomerService {
    private CustomerSender customerSender;
    private RestClient restClient;

    @Autowired
    public CustomerService(CustomerSender customerSender, RestClient restClient) {
        this.customerSender = customerSender;
        this.restClient = restClient;
    }

}
