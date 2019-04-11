package ru.gernik.stackexchange.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gernik.stackexchange.controller.converter.ResponseConverter;
import ru.gernik.stackexchange.controller.dto.SearchResponse;
import ru.gernik.stackexchange.service.StackExchangeService;
import ru.gernik.stackexchange.service.dto.SearchRequest;

@RestController
@RequiredArgsConstructor
public class StackExchangeController {

    private final StackExchangeService stackExchangeService;
    private final ResponseConverter responseConverter;

    @ApiOperation("Search for topics on the site stackoverflow")
    @GetMapping("/search")
    public SearchResponse search(@RequestParam(value = "order", required = false) String order,
                                 @RequestParam(value = "sort", required = false) String sort,
                                 @RequestParam(value = "filter", required = false) String filter,
                                 @RequestParam(value = "site") String site,
                                 @RequestParam(value = "query") String query) {
        return responseConverter.toSearchResponse(stackExchangeService.search(SearchRequest.builder()
                .order(order)
                .sort(sort)
                .site(site)
                .filter(filter)
                .query(query)
                .build()));
    }
}
