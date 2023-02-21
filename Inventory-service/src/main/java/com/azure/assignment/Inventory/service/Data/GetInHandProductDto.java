package com.azure.assignment.Inventory.service.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data@NoArgsConstructor
@AllArgsConstructor
public class GetInHandProductDto {

    private Long productId;
    private String inHandProduct;
    private String availableATWareHouse;
    private String modelNumber;
}
