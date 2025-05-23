package com.wings.product.Repository;

import com.wings.product.Entity.ProductItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository <ProductItemEntity , Long > {
}
