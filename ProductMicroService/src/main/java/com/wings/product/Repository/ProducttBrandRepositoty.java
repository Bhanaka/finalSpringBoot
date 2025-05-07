package com.wings.product.Repository;

import com.wings.product.Entity.ProductBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducttBrandRepositoty extends JpaRepository<ProductBrandEntity,Long> {
}
