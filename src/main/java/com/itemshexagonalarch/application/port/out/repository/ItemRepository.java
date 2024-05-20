package com.itemshexagonalarch.application.port.out.repository;

import com.itemshexagonalarch.domain.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    List<Item> findAll();

    Optional<Item> findById(String id);

    void save(Item item);

    void deleteById(String id);
}
