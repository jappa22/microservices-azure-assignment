package com.azure.assignment.catalogue.service.Resources;

import com.azure.assignment.catalogue.service.Data.Spec;
import com.azure.assignment.catalogue.service.Entity.CatalogueEnt;
import com.azure.assignment.catalogue.service.Entity.GetProduct;
import com.azure.assignment.catalogue.service.Entity.SubCategory;
import com.azure.assignment.catalogue.service.Exception.InternalServiceException;
import com.azure.assignment.catalogue.service.Service.CatalogueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CatalogueResourceTest {

    @Mock
    private CatalogueService catalogueService;
    @InjectMocks
    private CatalogueResource catalogueResource;

    @Test
    void getCatalogue() throws InternalServiceException {
        Mockito.when(catalogueService.getAllCatalogue()).thenReturn(getCatalogueEnt());
        List<CatalogueEnt> catalogue = catalogueResource.getCatalogue();
        Assertions.assertNotNull(catalogue);
    }

    private List<CatalogueEnt> getCatalogueEnt() {
        List<CatalogueEnt> catalogueEnts = new ArrayList<>();
        CatalogueEnt catalogueEnt = new CatalogueEnt(1L,"Entertainment","TV");
        CatalogueEnt catalogueEnt1 = new CatalogueEnt(2L,"Entertainment","laptop");
        CatalogueEnt catalogueEnt2 = new CatalogueEnt(3L,"Cooling system","fridge");
        CatalogueEnt catalogueEnt3 = new CatalogueEnt(4L,"Cooling system","AC");
        CatalogueEnt catalogueEnt4 = new CatalogueEnt(5L,"Wash care","washing machine");
        CatalogueEnt catalogueEnt5 = new CatalogueEnt(6L,"Wash care","dish washer");
        catalogueEnts.add(catalogueEnt);
        catalogueEnts.add(catalogueEnt1);
        catalogueEnts.add(catalogueEnt2);
        catalogueEnts.add(catalogueEnt3);
        catalogueEnts.add(catalogueEnt4);
        catalogueEnts.add(catalogueEnt5);
        return catalogueEnts;
    }

    @Test
    void getProductsByCategory() throws InternalServiceException{
        Mockito.when(catalogueService.getProducts("entertainment")).thenReturn(getProds());
        List<CatalogueEnt> catalogue = catalogueResource.getProductsByCategory("entertainment");
        Assertions.assertNotNull(catalogue);
    }

    private List<CatalogueEnt> getProds() {
        List<CatalogueEnt> catalogueEnts = new ArrayList<>();
        CatalogueEnt catalogueEnt = new CatalogueEnt(1L,"Entertainment","TV");
        CatalogueEnt catalogueEnt1 = new CatalogueEnt(2L,"Entertainment","laptop");
        catalogueEnts.add(catalogueEnt);
        catalogueEnts.add(catalogueEnt1);
        return catalogueEnts;
    }

    @Test
    void getAllCatalogueWhenCategoryIsEmpty(){
        InternalServiceException thrown = Assertions.assertThrows(InternalServiceException.class, () -> {
            catalogueResource.getProductsByCategory(null);
        }, "category passed in the url is blank");
    }

    @Test
    void getProductsBySubCategory() throws InternalServiceException{
        Mockito.when(catalogueService.getProductsBySubCat("tv")).thenReturn(getSubProduct());
        List<SubCategory> productsBySubCategory = catalogueResource.getProductsBySubCategory("tv");
        Assertions.assertNotNull(productsBySubCategory);
    }

    private List<SubCategory> getSubProduct() {
        List<SubCategory> subCategoryList = new ArrayList<>();
        SubCategory subCategory = new SubCategory();
        subCategory.setModelId("123");
        subCategory.setProductType("tv");
        subCategory.setSubCategoryId(1L);
        subCategory.setDetails("OLED tv");
        GetProduct getProduct = new GetProduct();
        getProduct.setProductId(1l);
        getProduct.setDetails("OLED tv");
        getProduct.setModelNumber("123");
        Spec spec = new Spec("4K","Prime","Netflix","LED","4K");
        getProduct.setSpec(spec);
        getProduct.setSize("55 inch");
        subCategory.setGetProduct(getProduct);
        subCategoryList.add(subCategory);
        return subCategoryList;
    }

    @Test
    void getAllCatalogueWhenProductNameIsEmpty(){
        InternalServiceException thrown = Assertions.assertThrows(InternalServiceException.class, () -> {
            catalogueResource.getProductsBySubCategory(null);
        }, "Product passed in the url is blank");
    }

    @Test
    void getProductDetails() throws InternalServiceException{
        Mockito.when(catalogueService.getProductDetails("123")).thenReturn(getProducDetails());
        GetProduct productDetails = catalogueResource.getProductDetails("123");
        Assertions.assertNotNull(productDetails);
    }

    private GetProduct getProducDetails() {
        GetProduct getProduct = new GetProduct();
        getProduct.setProductId(1l);
        getProduct.setDetails("OLED tv");
        getProduct.setModelNumber("123");
        Spec spec = new Spec("4K","Prime","Netflix","LED","4K");
        getProduct.setSpec(spec);
        getProduct.setSize("55 inch");
        return getProduct;
    }

    @Test
    void getAllCatalogueWhenIdIsEmpty(){
        InternalServiceException thrown = Assertions.assertThrows(InternalServiceException.class, () -> {
            catalogueResource.getProductDetails(null);
        }, "id passed in the url is blank");
    }
}
