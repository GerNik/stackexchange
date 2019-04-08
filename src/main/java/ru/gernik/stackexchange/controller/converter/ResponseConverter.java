package ru.gernik.stackexchange.controller.converter;

import org.mapstruct.Mapper;
import ru.gernik.stackexchange.controller.dto.SearchResponse;
import ru.gernik.stackexchange.service.client.dto.StackExchangeResponse;

@Mapper(componentModel = "spring")
public interface ResponseConverter {

    SearchResponse toSearchResponse(StackExchangeResponse response);
}
