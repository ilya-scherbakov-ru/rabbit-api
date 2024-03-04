package com.example.rabbit_api.models;

public class Case {
    private String customerId;
    private String caseText;

    public Case(String customerId, String caseText) {
        this.customerId = customerId;
        this.caseText = caseText;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCaseText() {
        return caseText;
    }

    public void setCaseText(String caseText) {
        this.caseText = caseText;
    }
}
