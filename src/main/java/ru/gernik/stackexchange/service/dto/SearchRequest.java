package ru.gernik.stackexchange.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchRequest {
    private String order;
    private String sort;
    private String site;
    private String filter;
    private String query;
}
