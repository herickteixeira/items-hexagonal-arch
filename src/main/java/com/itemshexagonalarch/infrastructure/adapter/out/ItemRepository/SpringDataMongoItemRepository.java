package com.itemshexagonalarch.infrastructure.adapter.out.ItemRepository;

import com.itemshexagonalarch.infrastructure.adapter.out.document.ItemDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoItemRepository extends MongoRepository<ItemDocument, String> {
}
