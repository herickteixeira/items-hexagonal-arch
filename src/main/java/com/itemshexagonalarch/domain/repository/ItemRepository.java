package com.itemshexagonalarch.domain.repository;

import com.itemshexagonalarch.domain.model.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> getAllItems();
    Item getItemById(String id);
    void createItem(Item item);
    void updateItem(String id, Item item);
    void deleteItemById(String id);
}
