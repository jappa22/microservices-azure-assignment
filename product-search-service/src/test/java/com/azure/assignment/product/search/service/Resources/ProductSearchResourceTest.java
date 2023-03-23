package com.azure.assignment.product.search.service.Resources;

import com.azure.assignment.product.search.service.Exception.InternalServiceException;
import com.azure.assignment.product.search.service.Messages.InHandProducts;
import com.azure.assignment.product.search.service.Messages.InHandProductsResponse;
import com.azure.assignment.product.search.service.Service.ProductSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductSearchResourceTest {

    @Mock
    private ProductSearchService productSearchService;

    @Mock
    private InHandProductsResponse handProductsResponse;

    @InjectMocks
    private ProductSearchResource productSearchResource;

    @Test
    void getInHandProduct() throws InternalServiceException {
        Mockito.when(productSearchService.getInHandProduct("123")).thenReturn(getInhandProds());
        InHandProducts inHandProduct = productSearchResource.getInHandProduct("123");
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
    void getcount() throws InternalServiceException{
        Mockito.when(productSearchService.getInHandProducts("123")).thenReturn("2");
        InHandProductsResponse response = productSearchResource.getcount("123");
        Assertions.assertEquals("2", response.getCount());
        Assertions.assertEquals("Stock available", response.getStatusAvailable());
    }
}