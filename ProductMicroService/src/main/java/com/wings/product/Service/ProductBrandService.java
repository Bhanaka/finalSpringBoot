package com.wings.product.Service;

import com.wings.product.DTO.ProductBrandDTO;
import com.wings.product.Entity.ProductBrandEntity;
import com.wings.product.Repository.ProducttBrandRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBrandService {
    @Autowired
    private ProducttBrandRepositoty producttBrandRepositoty ;
    public List<ProductBrandEntity> getAllProductBrand(){
        return producttBrandRepositoty.findAll();
    }
    public ProductBrandEntity createProductBrand(ProductBrandDTO productBrandDTO){
        ProductBrandEntity brandEntity = new ProductBrandEntity() ;
        brandEntity.setDescription(productBrandDTO.getDescription());
        brandEntity.setIsActive(productBrandDTO.getIsActive());
        return producttBrandRepositoty.save(brandEntity);
    }
}
