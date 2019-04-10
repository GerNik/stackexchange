package ru.gernik.stackexchange.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.gernik.stackexchange.configuration.CommonProperties;
import ru.gernik.stackexchange.service.client.StackExchangeClient;
import ru.gernik.stackexchange.service.client.dto.StackExchangeResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class StackExchangeServiceImpl implements StackExchangeService {

    private final StackExchangeClient stackExchangeClient;
    private final CommonProperties commonProperties;

    @Cacheable(value = "searcn", key = "#query")
    @Override
    public StackExchangeResponse search(String query) {
        return stackExchangeClient.search(commonProperties.getKey(), "desc", "activity", "stackoverflow", "default", query);
    }
}
