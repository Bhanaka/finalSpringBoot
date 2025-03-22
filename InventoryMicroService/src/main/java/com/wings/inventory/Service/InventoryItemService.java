package com.wings.inventory.Service;

import com.wings.inventory.Dto.InventoryItemDTO;
import com.wings.inventory.Model.InventoryItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class InventoryItemService {
//    @Autowired private  InventoryItemDTO itemDTO ;
    public InventoryItemDTO createInventoryItem(InventoryItemDTO inventoryItemDTO){
        InventoryItemEntity inventoryItemEntity =new InventoryItemEntity() ;
        // Mapping fields from DTO to Entity

//        inventoryItemEntity.setItemCode(inventoryItemDTO.getItemCode());
//        inventoryItemEntity.setItemName(inventoryItemDTO.getItemName());
//        inventoryItemEntity.setItemBrand(inventoryItemDTO.getItemBrand());
//        inventoryItemEntity.setItemBuyPrice(inventoryItemDTO.getItemBuyPrice());
//        inventoryItemEntity.setItemSellingPrice(inventoryItemDTO.getItemSellingPrice());
//        inventoryItemEntity.setItemIsActive(inventoryItemDTO.getItemIsActive());
        return inventoryItemDTO;

    }
}
