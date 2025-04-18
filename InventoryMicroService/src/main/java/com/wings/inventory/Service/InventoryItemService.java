package com.wings.inventory.Service;

import com.wings.inventory.Dto.InventoryItemDTO;
import com.wings.inventory.Exception.ItemNotFoundException;
import com.wings.inventory.Model.InventoryItemEntity;
import com.wings.inventory.Repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class InventoryItemService {
//    @Autowired private  InventoryItemDTO itemDTO ;
    @Autowired
    private InventoryItemRepository inventoryItemRepository ;
    public InventoryItemDTO createInventoryItem(InventoryItemDTO inventoryItemDTO){

        InventoryItemEntity inventoryItemEntity =new InventoryItemEntity() ;
        // Mapping fields from DTO to Entity
        inventoryItemEntity.setItemCode(inventoryItemDTO.getItemCode());
        inventoryItemEntity.setItemName(inventoryItemDTO.getItemName());
        inventoryItemEntity.setItemBrand(inventoryItemDTO.getItemBrand());
        inventoryItemEntity.setItemBuyPrice(inventoryItemDTO.getItemBuyPrice());
        inventoryItemEntity.setItemSellingPrice(inventoryItemDTO.getItemSellingPrice());
        inventoryItemEntity.setItemIsActive(inventoryItemDTO.getItemIsActive());

        // save the entity to the database
        InventoryItemEntity savedEntity = inventoryItemRepository.save(inventoryItemEntity) ;

        // Convert the saved entity back to a DTO to return
        InventoryItemDTO savedItemDTO = new InventoryItemDTO();
                savedEntity.getItemCode();
                savedEntity.getItemName();
                savedEntity.getItemBrand();
                savedEntity.getItemBuyPrice();
                savedEntity.getItemSellingPrice();
                savedEntity.getItemIsActive();

        return inventoryItemDTO;

    }
    public List<InventoryItemEntity> getAllInventoryItems(){
        return inventoryItemRepository.findAll();
    }
    public ResponseEntity<InventoryItemEntity> findById(Long id){
        Optional<InventoryItemEntity> item = inventoryItemRepository.findById(id) ;
        //If found, return 200 OK with the item
        if(item.isPresent()){
            return ResponseEntity.ok(item.get());
        }else{
            // If not found, return 404 Not Found
//            return ResponseEntity.notFound().build();
            // exception handler
//            throw new RuntimeException("item id not found ");
            // create custom exception handler
            throw  new ItemNotFoundException("Inventory Item Not Found");
        }
    }
    public InventoryItemDTO updatedItem(Long id , InventoryItemDTO inventoryItemDTO){
        InventoryItemEntity itemEntity = inventoryItemRepository.findById(id).orElseThrow();
        inventoryItemDTO.setItemId(itemEntity.getId());
        inventoryItemDTO.setItemBrand(itemEntity.getItemBrand());
        inventoryItemDTO.setItemCode(itemEntity.getItemCode());
        System.out.printf(String.valueOf(inventoryItemDTO));
        return  inventoryItemDTO ;
    }
}
