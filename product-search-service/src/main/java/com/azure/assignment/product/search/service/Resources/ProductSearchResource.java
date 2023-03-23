package com.azure.assignment.product.search.service.Resources;

import com.azure.assignment.product.search.service.Exception.InternalServiceException;
import com.azure.assignment.product.search.service.Messages.InHandProducts;
import com.azure.assignment.product.search.service.Messages.InHandProductsResponse;
import com.azure.assignment.product.search.service.Service.ProductSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GetInHandProduct")
@Slf4j
public class ProductSearchResource {

    @Autowired
    private ProductSearchService productSearchService;

    Logger logger = LoggerFactory.getLogger(ProductSearchResource.class);

    @GetMapping("/getProduct/{modelNumber}")
    public InHandProducts getInHandProduct(@PathVariable String modelNumber) throws InternalServiceException{
        if(StringUtils.isBlank(modelNumber)){
            logger.error("modelnumber passed in the url is blank", logger.getClass());
            throw new InternalServiceException("model number passed in blank/null ", "E11111");
        }
        logger.trace("inside getInHandProduct method of product search service", logger.getClass());
        InHandProducts inHandProduct = productSearchService.getInHandProduct(modelNumber);
        return inHandProduct;
    }

    @GetMapping("/getcount/{modelNumber}")
    public InHandProductsResponse getcount(@PathVariable String modelNumber) throws InternalServiceException{
        logger.trace("inside getcount method of product search service", logger.getClass());
        if(StringUtils.isBlank(modelNumber)){
            logger.error("modelnumber passed in the url is blank",logger.getClass());
            throw new InternalServiceException("model number passed in blank/null ", "E11111");
        }
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
