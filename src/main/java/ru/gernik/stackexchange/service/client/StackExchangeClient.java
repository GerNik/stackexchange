package ru.gernik.stackexchange.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gernik.stackexchange.service.client.dto.StackExchangeResponse;

@FeignClient(value = "stack-exchange-api", url = "${stackexchange.endpoint}")
public interface StackExchangeClient {

    @GetMapping("/search")
    StackExchangeResponse search(@RequestParam("key") String key,
                                 @RequestParam("order") String order,
                                 @RequestParam("sort") String sort,
                                 @RequestParam("site") String site,
                                 @RequestParam("intitle") String inTitle);
}
