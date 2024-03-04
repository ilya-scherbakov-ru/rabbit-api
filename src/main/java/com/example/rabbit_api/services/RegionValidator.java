package com.example.rabbit_api.services;

import com.example.rabbit_api.models.Customer;
import org.springframework.web.client.RestClient;

public class RegionValidator {
    private String customerId;
    private String region = null;

    public RegionValidator(String customerId) {
        this.customerId = customerId;
    }
    public String Validate () {
        RestClient restClient = RestClient.create();
        Customer customer = restClient.get()
                .uri("http://localhost:8080/api/customers/"+this.customerId)
                .retrieve()
                .body(Customer.class);
        return customer.getRegion();
    }
}
