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
import java.util.Optional;

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
    public ResponseEntity<InventoryItemEntity> getInventoryItem(@PathVariable Long id){
        Optional<InventoryItemEntity> item = inventoryItemService.findById(id) ;
        //If found, return 200 OK with the item
        if(item.isPresent()){
            return ResponseEntity.ok(item.get());
        }else{
            // If not found, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update_item/{id}")
    public ResponseEntity<InventoryItemDTO> updateInventoryItem(@PathVariable Long id , @RequestBody InventoryItemDTO updateItemDTO){
        InventoryItemDTO inventoryItemDTO = inventoryItemService.updatedItem(id,updateItemDTO) ;
        return ResponseEntity.ok(inventoryItemDTO);
    }

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
