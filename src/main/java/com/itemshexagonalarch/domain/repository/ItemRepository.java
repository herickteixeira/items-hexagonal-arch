package com.itemshexagonalarch.domain.repository;

import com.itemshexagonalarch.domain.model.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> getAllItems();
    Item getItemById(String id);
    void createItem(Item item);
    void updateItem(Item item);
    void deleteItem(String id);
}
