package com.azure.assignment.catalogue.service.Resources;

import com.azure.assignment.catalogue.service.Entity.CatalogueEnt;
import com.azure.assignment.catalogue.service.Entity.GetProduct;
import com.azure.assignment.catalogue.service.Entity.SubCategory;
import com.azure.assignment.catalogue.service.Exception.InternalServiceException;
import com.azure.assignment.catalogue.service.Service.CatalogueService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
@Slf4j
public class CatalogueResource {

    @Autowired
    private CatalogueService catalogueService;

    Logger logger = LoggerFactory.getLogger(CatalogueResource.class);

    @GetMapping("/getAllCatalogue")
    public List<CatalogueEnt> getCatalogue() throws InternalServiceException {
        logger.trace("Inside getCatalogue method of Catalogue service");
        return catalogueService.getAllCatalogue();
    }

    @GetMapping("/getProductsByCategory/{category}")
    public List<CatalogueEnt> getProductsByCategory (@PathVariable String category) throws InternalServiceException {
        logger.trace("Inside getProductsByCategory method of Catalogue service");
        if(category == null){
            logger.error("category passed in the url is blank");
            throw new InternalServiceException("Internal service exception ","E11111");
        }
        return catalogueService.getProducts(category);
    }

    @GetMapping("/getProductOfSubCategory/{productName}")
    public List<SubCategory> getProductsBySubCategory (@PathVariable String productName) throws InternalServiceException {
        logger.trace("Inside getProductsBySubCategory method of catalogue service");
        if(productName == null){
            logger.error("Product passed in the url is blank");
            throw new InternalServiceException("Internal service exception ","E11111");
        }
        List<SubCategory> productsBySubCat = catalogueService.
                getProductsBySubCat(productName);
        String modelNumber;
        for (SubCategory subCategory : productsBySubCat) {
            modelNumber = subCategory.getGetProduct().getModelNumber();
            subCategory.setModelId(modelNumber);
        }
        return productsBySubCat;
    }

    @GetMapping("/getProduct/{id}")
    public GetProduct getProductDetails(@PathVariable String id) throws InternalServiceException{
        logger.trace("inside getProductDetails method of catalogue service");
        if(id == null){
            logger.error("id passed in the url is blank");
            throw new InternalServiceException("Internal service exception ","E11111");
        }
        return catalogueService.getProductDetails(id);

    }

}
