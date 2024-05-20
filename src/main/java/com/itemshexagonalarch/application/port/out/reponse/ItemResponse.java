package com.itemshexagonalarch.application.port.out.reponse;

import com.itemshexagonalarch.domain.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
    private String id;
    private String name;
    private String description;

    public static ItemResponse toItem(Item item) {
        return new ItemResponse(item.getId(), item.getName(), item.getDescription());
    }

    public static List<ItemResponse> toItem(List<Item> tasks) {
        return tasks.stream()
                .map(ItemResponse::toItem)
                .collect(Collectors.toList());
    }
}
