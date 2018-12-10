package com.cardealership.domain.model.binding.cars;

import java.util.List;

public class CreateCarWithPartsBindingModel extends CreateCarBindingModel {
    private List<String> parts;

    public CreateCarWithPartsBindingModel() {
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }
}