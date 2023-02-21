package com.azure.assignment.catalogue.service.Resources;

import com.azure.assignment.catalogue.service.Entity.CatalogueEnt;
import com.azure.assignment.catalogue.service.Entity.GetProduct;
import com.azure.assignment.catalogue.service.Entity.SubCategory;
import com.azure.assignment.catalogue.service.Service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class CatalogueResource {

    @Autowired
    private CatalogueService catalogueService;

    @GetMapping("/getAllCatalogue")
    public List<CatalogueEnt> getCatalogue() {
        List<CatalogueEnt> allCatalogue = catalogueService.getAllCatalogue();
        return allCatalogue;
    }

    @GetMapping("/GetProductsByCategory/{category}")
    public List<CatalogueEnt> getProductsByCategory (@PathVariable String category){
        return catalogueService.getProductsByCat(category);
    }

    @GetMapping("/GetProductOfSubCategory/{product}")
    public List<SubCategory> getProductsBySubCategory (@PathVariable String product){
        List<SubCategory> productsBySubCat = catalogueService.getProductsBySubCat(product);
        String modelNumber;
        for (SubCategory subCategory : productsBySubCat) {
            modelNumber = subCategory.getGetProduct().getModelNumber();
            subCategory.setModelId(modelNumber);
        }
        return productsBySubCat;
    }

    @GetMapping("/getProduct/{id}")
    public GetProduct getProductDetails(@PathVariable String id){
        return catalogueService.getProductDetails(id);

    }

}
