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
        if(id == null || id < 0 ){
            throw new IllegalArgumentException("Invalid Id : ID must be a positive number ");
        }
        Optional<InventoryItemEntity> item = inventoryItemRepository.findById(id) ;
        try{
            if(item.isPresent()){
                return ResponseEntity.ok(item.get());
            }else{
                throw  new ItemNotFoundException("Inventory Item Not Found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred while fetching item with ID: " + id, e);
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
