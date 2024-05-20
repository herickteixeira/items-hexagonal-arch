package com.itemshexagonalarch.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String id;
    private String name;
    private String description;

    private Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Item create(String name, String description) {
        return new Item(name, description);
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
