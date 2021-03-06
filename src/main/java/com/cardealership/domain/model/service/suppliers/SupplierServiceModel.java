package com.cardealership.domain.model.service.suppliers;

public class SupplierServiceModel {
    private Long id;

    private String name;

    private boolean importer;

    public SupplierServiceModel() {
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

    public boolean isImporter() {
        return importer;
    }

    public void setImporter(boolean importer) {
        this.importer = importer;
    }
}
