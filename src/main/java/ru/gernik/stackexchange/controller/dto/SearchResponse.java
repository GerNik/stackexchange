package ru.gernik.stackexchange.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
    private Integer quotaMax;
    private Integer quotaRemaining;
    private Boolean hasMore;
    private List<Item> items;
}