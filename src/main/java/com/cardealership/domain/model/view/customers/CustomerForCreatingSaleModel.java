package com.cardealership.domain.model.view.customers;

public class CustomerForCreatingSaleModel {
    private Long id;

    private String name;

    private boolean young;

    public CustomerForCreatingSaleModel() {
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

    public boolean isYoung() {
        return young;
    }

    public void setYoung(boolean young) {
        this.young = young;
    }
}