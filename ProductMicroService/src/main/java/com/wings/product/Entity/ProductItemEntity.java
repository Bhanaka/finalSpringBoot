package com.wings.product.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_product_item")
@Data
public class ProductItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "name")
    private String productName ;
    @Column(name = "description")
    private String productDescription ;
    @Column(name = "brand")
    private String productBrand ;
    @Column(name = "company_code")
    private String productCompanyCode ;
    @Column(name = "wings_code")
    private String productWingsCode ;
    @Column(name = "buy_price")
    private float productBuyPrice ;
    @Column(name = "selling_price")
    private float productSellingPrice;
    @Column(name = "percentage")
    private float productDiscountPercentage ;
    @Column(name = "isactive")
    private boolean productIsActive ;
    @Column(name = "date")
    private LocalDateTime productSaveTime ;


}
