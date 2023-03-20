package com.azure.assignment.product.search.service.Messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InHandProductsRequestDto {

    private String inHandProduct;
    private String modelNumber;

    public String getInHandProduct() {
        return inHandProduct;
    }

    public void setInHandProduct(String inHandProduct) {
        this.inHandProduct = inHandProduct;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }
}
