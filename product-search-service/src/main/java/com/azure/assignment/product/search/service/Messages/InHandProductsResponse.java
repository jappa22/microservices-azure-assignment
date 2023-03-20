package com.azure.assignment.product.search.service.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InHandProductsResponse {

    private String statusAvailable;
    private String count;
}
