package com.azure.assignment.Inventory.service.resources;

import com.azure.assignment.Inventory.service.Config.MQConfig;
import com.azure.assignment.Inventory.service.Data.AddInventoryRequest;
import com.azure.assignment.Inventory.service.Data.GetInHandProductDto;
import com.azure.assignment.Inventory.service.Data.RemoveItemsFromInventoryRequest;
import com.azure.assignment.Inventory.service.Exception.InternalServiceException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/inventory")
@Slf4j
public class InventoryResource {

    @Autowired
    private RabbitTemplate template;

    Logger logger = LoggerFactory.getLogger(InventoryResource.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getInventoryOfProduct/{modelNumber}")
    public GetInHandProductDto GetInventoryOfProduct(@PathVariable String modelNumber) throws InternalServiceException {
        try {
            ResponseEntity<GetInHandProductDto> forEntity = restTemplate.getForEntity("http://20.207.109.236:80/GetInHandProduct/getProduct/" + modelNumber,
                    GetInHandProductDto.class);
            if(!forEntity.hasBody()){
                throw new InternalServiceException("Internal service exception", "E11111");
            }
            return forEntity.getBody();
        } catch (RestClientException exception) {
            logger.error("exception while connect to other MS", exception);
            throw new InternalServiceException("Internal service exception", "E11111");
        }
    }

    @PostMapping(value = "/addInventory",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity addItemsToInventory(@RequestBody AddInventoryRequest addInventoryRequest) throws InternalServiceException {
        try {
            template.convertAndSend(MQConfig.MESSAGE_EXCHANGE,
                    MQConfig.MESSAGE_ROUTINGKEY,
                    addInventoryRequest);
            return ResponseEntity.noContent().build();
        } catch (AmqpException exception) {
            logger.error("Message queue exception", exception);
            throw new InternalServiceException("Internal service exception", "E11111");
        }
    }

    @PostMapping(value = "/deleteInventory",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity deleteItemsFromInventory(@RequestBody RemoveItemsFromInventoryRequest inventoryRequest) throws InternalServiceException {
        try {
            template.convertAndSend(MQConfig.MESSAGE_EXCHANGE,
                    MQConfig.MESSAGE_ROUTINGKEY,
                    inventoryRequest);
            return ResponseEntity.noContent().build();
        } catch (AmqpException exception) {
            logger.error("Message queue exception", exception);
            throw new InternalServiceException("Internal service exception", "E11111");
        }
    }

}
