package com.wings.inventory.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/inventory")

public class InventoryItemController {
    @PostMapping("/create_item")
    public void createInventoryItem(){
    }
    @GetMapping("get_item/{id}")
    public void getInventoryItem(@PathVariable Long id){}
    @PutMapping("/update_item/{id}")
    public void updateInventoryItem(@PathVariable Long id){}
    @DeleteMapping("/delete_item/{id}")
    public void deleteInventoryItem(@PathVariable Long id){}
    @GetMapping("/get_items")
    public void getAllInventoryItems(){
        System.out.println("hi");
    }
    @GetMapping("/hello")
    public void printHello(HttpServletResponse response) throws IOException {
        // Set the content type to plain text
        response.setContentType("text/plain");

        // Write "Hello" to the response body
        response.getWriter().write("Hello");
    }
}
