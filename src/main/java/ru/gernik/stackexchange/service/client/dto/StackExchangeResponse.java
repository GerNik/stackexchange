package ru.gernik.stackexchange.service.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StackExchangeResponse implements Serializable {
    @JsonProperty("quota_max")
    private Integer quotaMax;
    @JsonProperty("quota_remaining")
    private Integer quotaRemaining;
    @JsonProperty("has_more")
    private Boolean hasMore;
    private List<Item> items;
}