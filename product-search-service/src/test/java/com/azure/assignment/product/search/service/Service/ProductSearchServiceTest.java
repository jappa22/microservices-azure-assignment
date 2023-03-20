package com.azure.assignment.product.search.service.Service;

import com.azure.assignment.product.search.service.Messages.InHandProducts;
import com.azure.assignment.product.search.service.Repository.InHandProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductSearchServiceTest {

    @Mock
    private InHandProductRepository inHandProductRepository;

    @InjectMocks
    ProductSearchService productSearchService;

    @Test
    void getInHandProduct() {
        Mockito.when(inHandProductRepository.findByModelNumber("123")).thenReturn(getInhandProds());
        InHandProducts inHandProduct = productSearchService.getInHandProduct("123");
        Assertions.assertEquals(1l, inHandProduct.getProductId());
        Assertions.assertEquals("2", inHandProduct.getInHandProduct());
        Assertions.assertEquals("ABC123", inHandProduct.getAvailableATWareHouse());
        Assertions.assertEquals("123", inHandProduct.getModelNumber());
    }

    private InHandProducts getInhandProds() {
        InHandProducts inHandProducts = new InHandProducts(1l, "2", "ABC123", "123");
        return inHandProducts;
    }

    @Test
    void removeItems() {
        Mockito.when(inHandProductRepository.getCount("123")).thenReturn("1");
        String inHandProducts = productSearchService.getInHandProducts("123");
        Assertions.assertEquals("1", inHandProducts);
    }
}