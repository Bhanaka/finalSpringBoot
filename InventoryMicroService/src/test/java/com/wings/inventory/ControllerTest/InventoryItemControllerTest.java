package com.wings.inventory.ControllerTest;

import com.wings.inventory.Controller.InventoryItemController;
import com.wings.inventory.Model.InventoryItemEntity;
import com.wings.inventory.Repository.InventoryItemRepository;
import com.wings.inventory.Service.InventoryItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.modelmapper.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest(InventoryItemController.class)
public class InventoryItemControllerTest {
    @Autowired
    private MockMvc mockMvc ;
    @Mock
    private InventoryItemService inventoryItemService ;

    @Mock
    private InventoryItemRepository inventoryItemRepository ;

    @InjectMocks
    private InventoryItemController itemController ;

    @Test
    public void testGetAllInventoryItems() throws Exception{

        // arranage : create sample inventory items
        InventoryItemEntity item1= new InventoryItemEntity(
                1L,"testcode" ,"itemName","laypart",100.0,200.0,true
        ) ;
        InventoryItemEntity item2 = new InventoryItemEntity(
                2L,"testcode" ,"itemName","laypart",100.0,200.0,true
        ) ;
        List <InventoryItemEntity> mockItems = Arrays.asList(item1,item2) ;
        mockItems.forEach(System.out::println);
//        Mockito.when(inventoryItemRepository.findAll()).thenReturn(mockItems);
//        // Act: Call the method you want to test
//        List<InventoryItemEntity> result = inventoryItemService.getAllInventoryItems();
//
//        // Assert: Verify the results
//        assertNotNull(result); // Make sure the result is not null
//        assertEquals(2, result.size()); // Ensure the list size matches
//        assertEquals("testcode", result.get(0).getItemCode()); // Verify first item code
//        assertEquals("itemName", result.get(1).getItemName()); // Verify second item name
//
//        // Print the result (optional, for debugging purposes)
//        result.forEach(System.out::println);


    }


}
