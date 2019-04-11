package ru.gernik.stackexchange.service;

import ru.gernik.stackexchange.service.client.dto.StackExchangeResponse;
import ru.gernik.stackexchange.service.dto.SearchRequest;

public interface StackExchangeService {

    StackExchangeResponse search(SearchRequest request);
}
