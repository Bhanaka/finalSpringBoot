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

    @PostMapping("/addProduct")
    public void createNewProduct(){

    }
    @GetMapping("/get_all_brands")
    public List<ProductBrandEntity> getAllBrands(){
        List brandList =productBrandService.getAllProductBrand() ;

        return brandList;
    }
}
