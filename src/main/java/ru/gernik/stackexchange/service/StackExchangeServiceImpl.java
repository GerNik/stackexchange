package ru.gernik.stackexchange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gernik.stackexchange.configuration.CommonProperties;
import ru.gernik.stackexchange.service.client.StackExchangeClient;
import ru.gernik.stackexchange.service.client.dto.StackExchangeResponse;

@Service
@RequiredArgsConstructor
public class StackExchangeServiceImpl implements StackExchangeService {

    private final StackExchangeClient stackExchangeClient;
    private final CommonProperties commonProperties;

    @Override
    public StackExchangeResponse search(String query) {
        return stackExchangeClient.search(commonProperties.getKey(), "desc", "activity", "stackoverflow", query);
    }
}
