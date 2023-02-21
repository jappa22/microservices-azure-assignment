package com.azure.assignment.Inventory.service.resources;

import com.azure.assignment.Inventory.service.Config.MQConfig;
import com.azure.assignment.Inventory.service.Data.AddInventoryRequest;
import com.azure.assignment.Inventory.service.Data.GetInHandProductDto;
import com.azure.assignment.Inventory.service.Data.RemoveItemsFromInventoryRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/inventory")
public class InventoryResource {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getInventoryOfProduct/{modelNumber}")
    public GetInHandProductDto GetInventoryOfProduct(@PathVariable String modelNumber){
            ResponseEntity<GetInHandProductDto> forEntity = restTemplate.getForEntity("http://INHANDPRODUCTS-SERVICE/GetInHandProduct/getProduct/" +modelNumber,
                GetInHandProductDto.class);
        GetInHandProductDto body = forEntity.getBody();
        return body;
    }

    @PostMapping(value = "/addInventory",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void addItemsToInventory(@RequestBody AddInventoryRequest addInventoryRequest){
        template.convertAndSend(MQConfig.MESSAGE_EXCHANGE,
                MQConfig.MESSAGE_ROUTINGKEY,
                addInventoryRequest);
    }

    @PostMapping(value = "/deleteInventory",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteItemsFromInventory(@RequestBody RemoveItemsFromInventoryRequest inventoryRequest){
        template.convertAndSend(MQConfig.MESSAGE_EXCHANGE,
                MQConfig.MESSAGE_ROUTINGKEY,
                inventoryRequest);
    }

}
