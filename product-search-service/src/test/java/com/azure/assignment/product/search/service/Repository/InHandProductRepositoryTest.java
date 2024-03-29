package com.azure.assignment.product.search.service.Repository;

import com.azure.assignment.product.search.service.Messages.InHandProducts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class InHandProductRepositoryTest {

    @Autowired
    private InHandProductRepository inHandProductRepository;

    @Test
    public void saveInHandProduct() {
        InHandProducts inHandProducts = InHandProducts.builder()
                .productId(1l)
                .inHandProduct("12")
                .availableATWareHouse("ABC123")
                .modelNumber("123")
                .build();
        inHandProductRepository.save(inHandProducts);
    }

    @Test
    public void saveInHandProduct1() {
        InHandProducts inHandProducts = InHandProducts.builder()
                .productId(2l)
                .inHandProduct("23")
                .availableATWareHouse("WERTYUIOUY12345")
                .modelNumber("234")
                .build();
        inHandProductRepository.save(inHandProducts);
    }
}
