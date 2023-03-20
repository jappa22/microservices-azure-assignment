package com.azure.assignment.product.search.service.Resources;

import com.azure.assignment.product.search.service.Messages.InHandProducts;
import com.azure.assignment.product.search.service.Messages.InHandProductsResponse;
import com.azure.assignment.product.search.service.Service.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GetInHandProduct")
public class ProductSearchResource {

    @Autowired
    private ProductSearchService productSearchService;

    @GetMapping("/getProduct/{modelNumber}")
    public InHandProducts getInHandProduct(@PathVariable String modelNumber) {
        InHandProducts inHandProduct = productSearchService.getInHandProduct(modelNumber);
        return inHandProduct;
    }

    @GetMapping("/getcount/{modelNumber}")
    public InHandProductsResponse getcount(@PathVariable String modelNumber) {
        String inHandProducts = productSearchService.getInHandProducts(modelNumber);
        InHandProductsResponse handProductsResponse = new InHandProductsResponse();
        if (Integer.parseInt(inHandProducts) > 0) {
            handProductsResponse.setCount(inHandProducts);
            handProductsResponse.setStatusAvailable("Stock available");
            return handProductsResponse;
        } else {
            handProductsResponse.setStatusAvailable("Stock not available");
            handProductsResponse.setCount(inHandProducts);
            return handProductsResponse;
        }
    }
}
