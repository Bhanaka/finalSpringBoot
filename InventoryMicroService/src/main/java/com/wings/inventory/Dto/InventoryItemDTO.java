package com.wings.inventory.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemDTO {
    private Integer itemId ;
    private String itemCode ;
    private String itemName ;
    private String itemBrand ;
    private Double itemBuyPrice ;
    private Double itemSellingPrice ;
    private Boolean itemIsActive ;

}
