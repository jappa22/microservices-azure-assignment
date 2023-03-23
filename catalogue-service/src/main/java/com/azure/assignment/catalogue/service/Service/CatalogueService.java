package com.azure.assignment.catalogue.service.Service;

import com.azure.assignment.catalogue.service.Entity.CatalogueEnt;
import com.azure.assignment.catalogue.service.Entity.GetProduct;
import com.azure.assignment.catalogue.service.Entity.SubCategory;
import com.azure.assignment.catalogue.service.Exception.InternalServiceException;
import com.azure.assignment.catalogue.service.Repository.CatalogueRepository;
import com.azure.assignment.catalogue.service.Repository.GetProductRepository;
import com.azure.assignment.catalogue.service.Repository.SubCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@Slf4j
public class CatalogueService {

    @Autowired
    private CatalogueRepository repository;

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    GetProductRepository getProductRepository;

    Logger logger = LoggerFactory.getLogger(CatalogueService.class);

    public List<CatalogueEnt> getAllCatalogue() throws InternalServiceException {
        logger.trace("inside getAllCatalogue method.", logger.getClass());
        List<CatalogueEnt> allCatalogue = repository.findAllByOrderByCategoryName();
        if(allCatalogue.isEmpty()){
            logger.error("no data found");
            throw new InternalServiceException("no data found","E11111");
        }
        return allCatalogue;
    }

    public List<CatalogueEnt> getProducts(String catName) throws InternalServiceException {
        logger.trace("inside getProducts method.", logger.getClass());
        List<CatalogueEnt> products = repository.findByCategoryName(catName);
        if(products.isEmpty()){
            logger.error("no data found for given category.");
            throw new InternalServiceException("no data found for given category.","E11111");
        }
        return products;
    }

    public List<SubCategory> getProductsBySubCat(String product) throws InternalServiceException {
        logger.trace("inside getProductsBySubCat method.", logger.getClass());
        List<SubCategory> productBySubCategory = subCategoryRepository.findByproductType(product);
        if(productBySubCategory.isEmpty()){
            logger.error("no data found for given product.");
            throw new InternalServiceException("no data found for given product.","E11111");
        }
        return productBySubCategory;
    }

    public GetProduct getProductDetails(String id) throws InternalServiceException{
        logger.trace("inside getProductDetails method.", logger.getClass());
        GetProduct productDetails = getProductRepository.findByModelNumber(id);
        if(productDetails == null){
            logger.error("no data found for given id.");
            throw new InternalServiceException("no data found for given id.","E11111");
        }
        return productDetails;
    }
}
