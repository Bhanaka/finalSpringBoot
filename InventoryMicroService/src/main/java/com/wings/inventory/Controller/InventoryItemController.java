package com.wings.inventory.Controller;

import com.wings.inventory.Dto.InventoryItemDTO;
import com.wings.inventory.Model.InventoryItemEntity;
import com.wings.inventory.Service.InventoryItemService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/inventory")

public class InventoryItemController {
    @Autowired
    private InventoryItemService inventoryItemService ;
    @PostMapping("/create_item")
    public ResponseEntity<InventoryItemDTO> createInventoryItem(@RequestBody InventoryItemDTO itemDTO){
        InventoryItemDTO inventoryItemDTO = inventoryItemService.createInventoryItem(itemDTO) ;
        return  new ResponseEntity<>(inventoryItemDTO , HttpStatus.CREATED);
    }
    @GetMapping("get_item/{id}")
    public void getInventoryItem(@PathVariable Long id){}
    @PutMapping("/update_item/{id}")
    public void updateInventoryItem(@PathVariable Long id){}
    @DeleteMapping("/delete_item/{id}")
    public void deleteInventoryItem(@PathVariable Long id){}

    @GetMapping("/get_items")
    public List<InventoryItemEntity> getAllInventoryItems(){
         return inventoryItemService.getAllInventoryItems();
    }
    @GetMapping("/hello")
    public void printHello(HttpServletResponse response) throws IOException {
        // Set the content type to plain text
        response.setContentType("text/plain");

        // Write "Hello" to the response body
        response.getWriter().write("Hello");
    }
}
