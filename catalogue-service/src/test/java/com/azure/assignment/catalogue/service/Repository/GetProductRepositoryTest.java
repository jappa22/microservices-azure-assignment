/*
package com.microservices.azure.assignment.catalogue.service.Repository;

import com.microservices.azure.assignment.catalogue.service.Data.Spec;
import com.microservices.azure.assignment.catalogue.service.Entity.GetProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetProductRepositoryTest {

    @Autowired
    GetProductRepository getProductRepository;

    @Test
    public void saveProduct(){

        Spec spec = Spec.builder()
                .display("LED")
                .internet("Play, Eros Now, JioCinema, SonyLiv")
                .services("Youtube, Hungama, Hotstar")
                .resolution("4K")
                .supported("Netflix, Prime Video, Zee5, Oxygen")
                .build();

        GetProduct getProduct = GetProduct.builder()
                .details("LED TV")
                .size("55 inch")
                .spec(spec)
                .modelNumber("123")
                */
/*.subCategory(subCategory)*//*

                .build();
        getProductRepository.save(getProduct);
    }
}*/
