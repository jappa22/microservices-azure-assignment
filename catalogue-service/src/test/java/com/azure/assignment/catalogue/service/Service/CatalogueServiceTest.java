package com.azure.assignment.catalogue.service.Service;

import com.azure.assignment.catalogue.service.Data.Spec;
import com.azure.assignment.catalogue.service.Entity.CatalogueEnt;
import com.azure.assignment.catalogue.service.Entity.GetProduct;
import com.azure.assignment.catalogue.service.Entity.SubCategory;
import com.azure.assignment.catalogue.service.Exception.InternalServiceException;
import com.azure.assignment.catalogue.service.Repository.CatalogueRepository;
import com.azure.assignment.catalogue.service.Repository.GetProductRepository;
import com.azure.assignment.catalogue.service.Repository.SubCategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CatalogueServiceTest {

    @Mock
    private CatalogueRepository repository;
    @InjectMocks
    private CatalogueService catalogueService;
    @Mock
    private SubCategoryRepository subCategoryRepository;
    @Mock
    private GetProductRepository getProductRepository;

    @Test
    void getAllCatalogue() throws InternalServiceException {
        Mockito.when(repository.findAllByOrderByCategoryName()).thenReturn(getCatalogueEnt());
        List<CatalogueEnt> allCatalogue = catalogueService.getAllCatalogue();
        Assertions.assertEquals(allCatalogue.get(0).getCatalogueId(),1L);
        Assertions.assertEquals(allCatalogue.get(0).getCategoryName(),"Entertainment");
        Assertions.assertEquals(allCatalogue.get(0).getProduct(),"TV");
        Assertions.assertEquals(allCatalogue.get(1).getCatalogueId(),2L);
        Assertions.assertEquals(allCatalogue.get(1).getCategoryName(),"Entertainment");
        Assertions.assertEquals(allCatalogue.get(1).getProduct(),"laptop");
    }

    @Test
    void getAllCatalogueWhenCatalogueIsEmpty(){
        Mockito.when(repository.findAllByOrderByCategoryName()).thenReturn(new ArrayList<>());
        InternalServiceException thrown = Assertions.assertThrows(InternalServiceException.class, () -> {
            catalogueService.getAllCatalogue();
        }, "no data found");
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
    void getProducts() throws InternalServiceException{
        Mockito.when(repository.findByCategoryName("Entertainment")).thenReturn(getProds());
        List<CatalogueEnt> products = catalogueService.getProducts("Entertainment");
        Assertions.assertEquals(products.get(0).getCatalogueId(),1L);
        Assertions.assertEquals(products.get(0).getCategoryName(),"Entertainment");
        Assertions.assertEquals(products.get(0).getProduct(),"TV");
    }

    @Test
    void getAllCatalogueWhenProductsIsEmpty(){
        Mockito.when(repository.findAllByOrderByCategoryName()).thenReturn(new ArrayList<>());
        InternalServiceException thrown = Assertions.assertThrows(InternalServiceException.class, () -> {
            catalogueService.getProducts("Entertainment");
        }, "no data found for given category.");
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
    void getProductsBySubCat() throws InternalServiceException{
        Mockito.when(subCategoryRepository.findByproductType("tv")).thenReturn(getSubProduct());
        List<SubCategory> productsBySubCat = catalogueService.getProductsBySubCat("tv");
        Assertions.assertEquals(productsBySubCat.get(0).getProductType(),"tv");
        Assertions.assertEquals(productsBySubCat.get(0).getDetails(),"OLED tv");
        Assertions.assertEquals(productsBySubCat.get(0).getModelId(),"123");
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
    void getAllCatalogueWhenGetProductsBySubCategoryIsEmpty(){
        Mockito.when(subCategoryRepository.findByproductType("tv")).thenReturn(new ArrayList<>());
        InternalServiceException thrown = Assertions.assertThrows(InternalServiceException.class, () -> {
            catalogueService.getProductsBySubCat("tv");
        }, "no data found for given category.");
    }

    @Test
    void getProductDetails() throws InternalServiceException{
        Mockito.when(getProductRepository.findByModelNumber("123")).thenReturn(getProducDetails());
        GetProduct productDetails = catalogueService.getProductDetails("123");
        Assertions.assertEquals(productDetails.getDetails(),"OLED tv");
        Assertions.assertEquals(productDetails.getProductId(),1l);
        Assertions.assertEquals(productDetails.getSize(),"55 inch");
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
    void getAllCatalogueWhenProductDetailsIsEmpty(){
        Mockito.when(getProductRepository.findByModelNumber("123")).thenReturn(null);
        InternalServiceException thrown = Assertions.assertThrows(InternalServiceException.class, () -> {
            catalogueService.getProductDetails("123");
        }, "no data found for given category.");
    }
}