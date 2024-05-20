package com.itemshexagonalarch.application.port.in.service;

import com.itemshexagonalarch.application.port.in.request.ItemRequest;
import com.itemshexagonalarch.application.port.out.reponse.ItemResponse;
import com.itemshexagonalarch.application.port.out.repository.ItemRepository;
import com.itemshexagonalarch.domain.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(ItemRequest itemRequest) {
        var item = Item.create(itemRequest.getName(), itemRequest.getDescription());
        itemRepository.save(item);
    }

    public List<ItemResponse> getAllItems() {
        var items = itemRepository.findAll();
        return ItemResponse.toItem(items);
    }

    public ItemResponse getItemById(String id) {
        var optionalItem = itemRepository.findById(id);
        if (optionalItem.isEmpty()) throw new RuntimeException(String.format("Item of id %s no found", id));
        return ItemResponse.toItem(optionalItem.get());
    }

    public ItemResponse updateItem(String id, ItemRequest itemRequest) {
        var optionalItem = itemRepository.findById(id);
        if (optionalItem.isEmpty()) throw new RuntimeException(String.format("Item of id %s no found", id));

        var item = optionalItem.get();

        item.update(itemRequest.getName(), itemRequest.getDescription());

        itemRepository.save(item);

        return ItemResponse.toItem(item);
    }

    public void deleteItemById(String id) {
        var optionalItem = itemRepository.findById(id);
        if (optionalItem.isEmpty()) throw new RuntimeException(String.format("Item of id %s no found", id));
        itemRepository.deleteById(id);
    }
}
