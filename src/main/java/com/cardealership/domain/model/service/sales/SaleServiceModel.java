package com.cardealership.domain.model.service.sales;

import com.cardealership.domain.model.service.cars.CarServiceModel;
import com.cardealership.domain.model.service.customers.CustomerServiceModel;

public class SaleServiceModel {
    private Long id;

    private CarServiceModel car;

    private CustomerServiceModel customer;

    private Double discount;

    public SaleServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarServiceModel getCar() {
        return car;
    }

    public void setCar(CarServiceModel car) {
        this.car = car;
    }

    public CustomerServiceModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerServiceModel customer) {
        this.customer = customer;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}