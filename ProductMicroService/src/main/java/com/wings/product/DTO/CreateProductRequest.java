package com.wings.product.DTO;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String productName ;
    private String productDescription ;
    private String productBrand ;
    private String productCompanyCode ;
    private String productWingsCode ;
    private float productBuyPrice ;
    private float productSellingPrice;
    private float productDiscountPercentage ;
    private boolean productIsActive ;
}
