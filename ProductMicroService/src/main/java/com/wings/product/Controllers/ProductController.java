package com.wings.product.Controllers;

import com.wings.product.DTO.ProductBrandDTO;
import com.wings.product.Entity.ProductBrandEntity;
import com.wings.product.Service.ProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/product")
public class ProductController {
    @Autowired
    private ProductBrandService productBrandService ;
    @PostMapping("/create_brand")
    public ResponseEntity<ProductBrandEntity> createBrand(@RequestBody ProductBrandDTO productBrandDTO){
//        ProductBrandEntity brand = new ProductBrandEntity();
//        brand.setDescription(productBrandDTO.getDescription());
//        brand.setIsActive(productBrandDTO.getIsActive());
//        productBrandService
//        System.out.println("new brands");
        return  productBrandService.createProductBrand(productBrandDTO);
//        return "create new brands" ;
    }
    @GetMapping("/get_all_brands")
    public List<ProductBrandEntity> getAllBrands(){
        List brandList =productBrandService.getAllProductBrand() ;

        return brandList;
    }
}
