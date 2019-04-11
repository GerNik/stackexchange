package ru.gernik.stackexchange.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.gernik.stackexchange.configuration.CommonProperties;
import ru.gernik.stackexchange.service.client.StackExchangeClient;
import ru.gernik.stackexchange.service.client.dto.StackExchangeResponse;
import ru.gernik.stackexchange.service.dto.SearchRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class StackExchangeServiceImpl implements StackExchangeService {

    private final StackExchangeClient stackExchangeClient;
    private final CommonProperties commonProperties;

    @Cacheable("search")
    @Override
    public StackExchangeResponse search(SearchRequest request) {
        return stackExchangeClient.search(commonProperties.getKey(), request.getOrder(),
                request.getSort(), request.getSite(),
                request.getFilter(), request.getQuery());
    }
}
