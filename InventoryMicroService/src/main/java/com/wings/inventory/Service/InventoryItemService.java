package com.wings.inventory.Service;

import com.wings.inventory.Dto.InventoryItemDTO;
import com.wings.inventory.Model.InventoryItemEntity;
import com.wings.inventory.Repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
