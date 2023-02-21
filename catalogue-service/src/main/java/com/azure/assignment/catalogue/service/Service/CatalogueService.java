package com.azure.assignment.catalogue.service.Service;

import com.azure.assignment.catalogue.service.Entity.CatalogueEnt;
import com.azure.assignment.catalogue.service.Entity.GetProduct;
import com.azure.assignment.catalogue.service.Entity.SubCategory;
import com.azure.assignment.catalogue.service.Repository.CatalogueRepository;
import com.azure.assignment.catalogue.service.Repository.GetProductRepository;
import com.azure.assignment.catalogue.service.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CatalogueService {

    @Autowired
    private CatalogueRepository repository;

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    GetProductRepository getProductRepository;

    public List<CatalogueEnt> getAllCatalogue(){
        return repository.findAllByOrderByCategoryName();
    }

    public List<CatalogueEnt> getProductsByCat(String catName) {
        return repository.findByCategoryName(catName);
    }

    public List<SubCategory> getProductsBySubCat(String product) {
        return subCategoryRepository.findByproductType(product);
    }

    public GetProduct getProductDetails(String id) {
        return getProductRepository.findByModelNumber(id);
    }
}
