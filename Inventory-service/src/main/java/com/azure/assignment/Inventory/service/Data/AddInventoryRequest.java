package com.azure.assignment.Inventory.service.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInventoryRequest {

    private String inHandProduct;
    private String modelNumber;
}
