package com.wings.product.Service;

import com.wings.product.DTO.CreateProductRequest;
import com.wings.product.Entity.ProductItemEntity;
import com.wings.product.Repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepository ;
    public ProductItemEntity saveProductItem(CreateProductRequest request){

        ProductItemEntity itemSave = new ProductItemEntity();

        itemSave.setProductName(request.getProductName());
        itemSave.setProductDescription(request.getProductDescription());
        itemSave.setProductBrand(request.getProductBrand());
        itemSave.setProductCompanyCode(request.getProductCompanyCode());
        itemSave.setProductWingsCode(request.getProductWingsCode());
        itemSave.setProductBuyPrice(request.getProductBuyPrice());
        itemSave.setProductSellingPrice(request.getProductSellingPrice());
        itemSave.setProductDiscountPercentage(request.getProductDiscountPercentage());
        itemSave.setProductIsActive(request.isProductIsActive());

        // save and return the saved entity
        return productItemRepository.save(itemSave) ;
    }
    public List<ProductItemEntity> getAllProduct(){
        List productList = productItemRepository.findAll();
        return productList ;
    }
}
