package com.itemshexagonalarch.infrastructure.adapter.out.ItemRepository;

import com.itemshexagonalarch.application.port.out.repository.ItemRepository;
import com.itemshexagonalarch.domain.model.Item;
import com.itemshexagonalarch.infrastructure.adapter.out.document.ItemDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MongoItemRepository implements ItemRepository {

    private final SpringDataMongoItemRepository repository;

    @Autowired
    public MongoItemRepository(SpringDataMongoItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Item> findAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(String id) {
        return repository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public void save(Item item) {
        ItemDocument document = toDocument(item);
        toDomain(repository.save(document));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    private Item toDomain(ItemDocument document) {
        return new Item(document.getId(), document.getName(), document.getDescription());
    }

    private ItemDocument toDocument(Item item) {
        ItemDocument document = new ItemDocument();
        document.setId(item.getId());
        document.setName(item.getName());
        document.setDescription(item.getDescription());
        return document;
    }
}
