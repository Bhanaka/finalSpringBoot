package com.wings.inventory.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "api/inventory")

public class InventoryItemController {
    public void createInventoryItem(){}
    public void getInventoryItem(@PathVariable Long id){}
    public void updateInventoryItem(@PathVariable Long id){}
    public void deleteInventoryItem(@PathVariable Long id){}
    public void getAllInventoryItems(){}
}
