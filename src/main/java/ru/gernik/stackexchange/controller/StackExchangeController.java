package ru.gernik.stackexchange.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gernik.stackexchange.service.StackExchangeService;
import ru.gernik.stackexchange.service.client.dto.StackExchangeResponse;

@RestController
@RequiredArgsConstructor
public class StackExchangeController {

    private final StackExchangeService stackExchangeService;

    @ApiOperation("Search for topics on the site stackoverflow")
    @GetMapping("/search")
    public StackExchangeResponse search(@RequestParam String query) {
        return stackExchangeService.search(query);
    }
}
