package com.example.rabbit_api.models;

public class Customer {
    private Integer customerId;
    private String Region;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public Customer() {
    }
}
