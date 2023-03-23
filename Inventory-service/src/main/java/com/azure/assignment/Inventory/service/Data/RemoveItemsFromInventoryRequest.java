package com.azure.assignment.Inventory.service.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemsFromInventoryRequest {

    @NotNull
    private String itemCountToRemove;
    @NotNull
    private String modelNumber;
}
