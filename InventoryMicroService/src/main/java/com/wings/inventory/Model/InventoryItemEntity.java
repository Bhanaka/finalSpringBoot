package com.wings.inventory.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_inventory_item")
public class InventoryItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "code")
    private String itemCode ;

    @Column(name = "name")
    private String itemName ;

    @Column(name = "brand")
    private String itemBrand ;

    @Column(name = "buyprice")
    private Double itemBuyPrice ;

    @Column(name = "sellingprice")
    private Double itemSellingPrice ;

    @Column(name = "isactive")
    private Boolean itemIsActive ;

}
