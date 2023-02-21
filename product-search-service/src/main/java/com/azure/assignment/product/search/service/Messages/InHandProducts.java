package com.azure.assignment.product.search.service.Messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InHandProducts {

    @Id
    @GeneratedValue
    private Long productId;
    private String inHandProduct;
    private String availableATWareHouse;
    private String modelNumber;
}
