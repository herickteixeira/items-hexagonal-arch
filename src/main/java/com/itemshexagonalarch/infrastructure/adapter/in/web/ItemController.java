package com.itemshexagonalarch.infrastructure.adapter.in.web;

import com.itemshexagonalarch.application.port.in.request.ItemRequest;
import com.itemshexagonalarch.application.port.in.service.ItemService;
import com.itemshexagonalarch.application.port.out.reponse.ItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody ItemRequest itemRequest) {
        itemService.createItem(itemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        var items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItemById(@PathVariable String id) {
        var taskResponse = itemService.getItemById(id);
        return ResponseEntity.ok(taskResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable String id, @RequestBody ItemRequest itemRequest) {
        var response = itemService.updateItem(id, itemRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable String id) {
        itemService.deleteItemById(id);
        return ResponseEntity.ok().build();
    }
}
