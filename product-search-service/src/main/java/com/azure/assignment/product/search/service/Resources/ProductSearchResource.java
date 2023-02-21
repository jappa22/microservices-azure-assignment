package com.azure.assignment.product.search.service.Resources;

import com.azure.assignment.product.search.service.Messages.InHandProducts;
import com.azure.assignment.product.search.service.Service.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GetInHandProduct")
public class ProductSearchResource {

    @Autowired
    ProductSearchService productSearchService;

    @GetMapping("/getProduct/{modelNumber}")
    public InHandProducts getInHandProduct(@PathVariable String modelNumber){
        InHandProducts inHandProduct = productSearchService.getInHandProduct(modelNumber);
        return inHandProduct;
    }

    @GetMapping("/getcount/{modelNumber}")
    public String getcount(@PathVariable String modelNumber){
        String inHandProducts = productSearchService.getInHandProducts(modelNumber);
        if(Integer.parseInt(inHandProducts) >0){
            return "Stock Available";
        }else return "not in stock";
    }
}
