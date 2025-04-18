package com.wings.inventory.Dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
public class InventoryItemDTO {
    public Long itemId ;
    private String itemCode ;
    private String itemName ;
    private String itemBrand ;
    private Double itemBuyPrice ;
    private Double itemSellingPrice ;
    private Boolean itemIsActive ;

}
