package com.azure.assignment.product.search.service.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecreaseProductCount {

    private String itemCountToRemove;
    private String modelNumber;

    public String getItemCountToRemove() {
        return itemCountToRemove;
    }

    public void setItemCountToRemove(String itemCountToRemove) {
        this.itemCountToRemove = itemCountToRemove;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }
}
