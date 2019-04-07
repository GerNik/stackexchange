package ru.gernik.stackexchange.service;

import ru.gernik.stackexchange.service.client.dto.StackExchangeResponse;

public interface StackExchangeService {

    StackExchangeResponse search(String query);
}
