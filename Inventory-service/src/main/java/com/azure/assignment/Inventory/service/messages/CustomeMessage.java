package com.azure.assignment.Inventory.service.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomeMessage {
    private String inHandProducts;
    private String modelNumbers;
}
