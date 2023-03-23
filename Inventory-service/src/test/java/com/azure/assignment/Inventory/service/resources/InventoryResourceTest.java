package com.azure.assignment.Inventory.service.resources;

import com.azure.assignment.Inventory.service.Data.AddInventoryRequest;
import com.azure.assignment.Inventory.service.Data.RemoveItemsFromInventoryRequest;
import com.azure.assignment.Inventory.service.Exception.InternalServiceException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class InventoryResourceTest {

    @Container
    static RabbitMQContainer rabbitMQContainer = new RabbitMQContainer(DockerImageName.parse("rabbitmq").withTag("3-management-alpine"));

    @InjectMocks
    InventoryResource inventoryResource;

    @Mock
    private RabbitTemplate template;

    @DynamicPropertySource
    static void configure(DynamicPropertyRegistry dynamicPropertyRegistry){
        dynamicPropertyRegistry.add("spring.rabbitmq.host", rabbitMQContainer::getHost);
        dynamicPropertyRegistry.add("spring.rabbitmq.port", rabbitMQContainer::getAmqpPort);
    }

    @Test
    void addItemsToInventory() throws InternalServiceException{
        ResponseEntity responseEntity = inventoryResource.addItemsToInventory(new AddInventoryRequest());
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals("204 NO_CONTENT",responseEntity.getStatusCode().toString());
    }

    @Test
    void deleteItemsFromInventory() throws InternalServiceException {
        ResponseEntity responseEntity = inventoryResource.deleteItemsFromInventory(new RemoveItemsFromInventoryRequest());
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals("204 NO_CONTENT",responseEntity.getStatusCode().toString());
    }
}
