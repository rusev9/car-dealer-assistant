package com.cardealership.domain.model.service.customers;

import java.math.BigInteger;

public class CustomerSalesServiceModel {

    private Long id;

    private String name;

    private Double totalResources;

    private BigInteger totalCars;

    public CustomerSalesServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalResources() {
        return totalResources;
    }

    public void setTotalResources(Double totalResources) {
        this.totalResources = totalResources;
    }

    public BigInteger getTotalCars() {
        return totalCars;
    }

    public void setTotalCars(BigInteger totalCars) {
        this.totalCars = totalCars;
    }
}