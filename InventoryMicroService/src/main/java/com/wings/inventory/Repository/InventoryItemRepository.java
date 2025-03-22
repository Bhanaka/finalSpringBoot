package com.wings.inventory.Repository;

import com.wings.inventory.Model.InventoryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItemEntity ,Long> {
}
