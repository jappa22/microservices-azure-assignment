package com.azure.assignment.product.search.service.Service;

import com.azure.assignment.product.search.service.Messages.InHandProducts;
import com.azure.assignment.product.search.service.Repository.InHandProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSearchService {

    @Autowired
    InHandProductRepository inHandProductRepository;

    public InHandProducts getInHandProduct(String modelNumber) {
        InHandProducts inHandProducts = inHandProductRepository.findByModelNumber(modelNumber);
        return inHandProducts;
    }

    public void addItems(String productCount, String modelNumber) {
        inHandProductRepository.updateItemsinDb(productCount, modelNumber);
    }

    public String getInHandProducts(String modelNumber) {
        String numberOfProducts = inHandProductRepository.getCount(modelNumber);
        return numberOfProducts;
    }

    public void removeItems(String toString, String modelNumber) {
        inHandProductRepository.updateItemsinDb(toString, modelNumber);
    }
}
