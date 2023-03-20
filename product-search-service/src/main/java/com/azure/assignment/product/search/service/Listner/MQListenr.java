package com.azure.assignment.product.search.service.Listner;

import com.azure.assignment.product.search.service.Config.MQConfig;
import com.azure.assignment.product.search.service.Messages.DecreaseProductCount;
import com.azure.assignment.product.search.service.Messages.InHandProductsRequestDto;
import com.azure.assignment.product.search.service.Service.ProductSearchService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQListenr {

    @Autowired
    ProductSearchService productSearchService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listner(InHandProductsRequestDto inHandProductsRequestDto) {
        String inHandProducts = (productSearchService.getInHandProducts(inHandProductsRequestDto.getModelNumber()));
        int i = (Integer.parseInt(inHandProducts) + Integer.parseInt(inHandProductsRequestDto.getInHandProduct()));
        productSearchService.addItems(Integer.toString(i), inHandProductsRequestDto.getModelNumber());
    }

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listnerForDelete(DecreaseProductCount decreaseProductCount) {
        String inHandProducts = (productSearchService.getInHandProducts(decreaseProductCount.getModelNumber()));
        int i = (Integer.parseInt(inHandProducts) - Integer.parseInt(decreaseProductCount.getItemCountToRemove()));
        productSearchService.removeItems(Integer.toString(i), decreaseProductCount.getModelNumber());
    }
}
