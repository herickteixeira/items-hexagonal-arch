package com.itemshexagonalarch.infrastructure.adapter.out.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "items")
public class ItemDocument {
    @Id
    private String id;
    private String name;
    private String description;
}
